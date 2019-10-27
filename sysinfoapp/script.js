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
        document.getElementById("top-panel").style.visibility = "visible";
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
        document.getElementById("top-panel").style.visibility = "hidden";
    },

    loadNotebook: function () {
        fs.readFile('file.json', (err, data) => {
            if (err) {
                throw err;
            }
            var json = JSON.parse(data.toString());
            removeAllChildNodes(document.getElementById("sidenav-content"));
            for (let i = 0; i < json.Notebooks.length; i++) {                
                var node = createContentElement(json.Notebooks[i].Nbookname);                                
                node.addEventListener('click', (event) => {                    
                    removeAllChildNodes(document.getElementById("sidenav-content"));
                    for (let j = 0; j < json.Notebooks[i].Notes.length; j++) {                        
                        var node = createContentElement(json.Notebooks[i].Notes[j].Notename);
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
    },
    createNewEntry: function(){
        var node = document.createElement("Input");
        document.getElementById("sidenav-content").appendChild(node);
    }
}

function removeAllChildNodes(parentNode) {
    var navNode = parentNode;
    var lastchild = navNode.lastElementChild;
    while (lastchild) {
        navNode.removeChild(lastchild);
        lastchild = navNode.lastElementChild;
    }
}

function createContentElement(name){    
    var node;
    if(name.length > 10){
        shortName = name.substr(0,8).concat("..");

        node = createChildNode(shortName,"a");
        node.addEventListener('mouseover',(event) => {
            node.appendChild(createChildNode(name,"span"));
        });
        node.addEventListener('mouseout',(event) => {            
            removeAllChildNodes(node);
        });
    } else {
        node = createChildNode(name,"a");
    }
    return node;
}

function createChildNode(name,tag){
    var textNode = document.createTextNode(name);
    var node = document.createElement(tag);
    node.appendChild(textNode);
    return node;
}
