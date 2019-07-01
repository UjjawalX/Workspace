var fs = require('fs-extra');
var lodash = require('lodash');
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
    load: function (event) {
        var nbook = event.target.text;
        var json;
        fs.readFile('file.json', (err, data) => {
            if (err) throw err;
            json = JSON.parse(data.toString());
            for (let i = 0; i < json.Notebooks.length; i++) {
                if (json.Notebooks[i].Nbookname === nbook) {
                    for (let j = 0; j < json.Notebooks[i].Notes.length; j++) {
                        var node = document.createElement("a");
                        var textnode = document.createTextNode(json.Notebooks[i].Notes[j].Notename);
                        node.appendChild(textnode);
                        document.getElementById("sidenav-content").appendChild(node);
                    }
                }
            }
        });

    },

    loadNotebook : function(){
        fs.readFile('file.json',(err, data) => {
            if(err){
                throw err;                
            }
            var json = JSON.parse(data.toString());
            removeAllChildNodes();
            for (let i = 0; i < json.Notebooks.length; i++) {
                var nbookname =json.Notebooks[i].Nbookname;
                var textNode = document.createTextNode(nbookname);
                var node = document.createElement("a");
                node.appendChild(textNode);
                node.addEventListener('click',(event) => { 
                    var nbook = event.target.text;
                    for(let i =0 ; i < json.Notebooks.length; i++){
                        if (json.Notebooks[i].Nbookname === nbook) {
                            removeAllChildNodes();
                            
                            for (let j = 0; j < json.Notebooks[i].Notes.length; j++) {
                                var textnode = document.createTextNode(json.Notebooks[i].Notes[j].Notename);
                                var node = document.createElement("a");
                                node.appendChild(textnode);                            
                                document.getElementById("sidenav-content").appendChild(node);
                            }
                        }
                    }
                });
                document.getElementById("sidenav-content").appendChild(node);
            }
        });
    },
    
}

function removeAllChildNodes() {
    var navNode = document.getElementById("sidenav-content");
    var lastchild = navNode.lastElementChild;
    while (lastchild) {
        navNode.removeChild(lastchild);
        lastchild = navNode.lastElementChild;
    }
}
