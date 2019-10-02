var fs = require('fs-extra');
var lodash = require('lodash');
var notefilename;
var myapp = {
    open: function () {
        document.getElementById("sidenav").style.width = "125px";
        document.getElementById("notearea").style.marginLeft = "195px";

        var len = document.getElementById("sidenav").getElementsByTagName("a").length;
        for (let i = 0; i < len; i++) {
            document.getElementById("sidenav").getElementsByTagName("a").item(i).style.visibility = "visible";
        }
        //with lodash
        // var collection = document.getElementById("sidenav").getElementsByTagName("a");
        // lodash.forEach(collection , ( a => a.style.visibility = "visible"));
    },
    close: function () {
        document.getElementById("sidenav").style.width = "25px";
        document.getElementById("notearea").style.marginLeft = "95px";
        var len = document.getElementById("sidenav").getElementsByTagName("a").length;
        for (let i = 0; i < len; i++) {
            document.getElementById("sidenav").getElementsByTagName("a").item(i).style.visibility = "hidden";
        }
    },

    loadNotebook: function () {
        fs.readFile('file.json', (err, data) => {
            if (err) {
                throw err;
            }
            var json = JSON.parse(data.toString());
            removeAllChildNodes();
            for (let i = 0; i < json.Notebooks.length; i++) {                
                var node = createChildNodes(json.Notebooks[i].Nbookname);                                
                node.addEventListener('click', (event) => {                    
                    removeAllChildNodes();
                    for (let j = 0; j < json.Notebooks[i].Notes.length; j++) {                        
                        var node = createChildNodes(json.Notebooks[i].Notes[j].Notename);
                        node.addEventListener('click', (event) => {                                                     
                            notefilename = json.Notebooks[i].Notes[j].Content;
                            fs.readFile(notefilename , (err,data) => {                                
                                document.getElementById("textarea").value = data;
                            })
                        });
                        document.getElementById("sidenav-content").appendChild(node);
                    }
                });
                document.getElementById("sidenav-content").appendChild(node);
            }
        });
    },
    save : function (){
        fs.writeFile(notefilename,document.getElementById("textarea").value,(err) => {
            if(err)
                throw err;
            console.log("file saved");
        });
    }
}

function removeAllChildNodes() {
    var navNode = document.getElementById("sidenav-content");
    var lastchild = navNode.lastElementChild;
    while (lastchild) {
        navNode.removeChild(lastchild);
        lastchild = navNode.lastElementChild;
    }
}

function createChildNodes(name){
    var textNode = document.createTextNode(name);
    var node = document.createElement("a");
    node.appendChild(textNode);
    return node;
}

