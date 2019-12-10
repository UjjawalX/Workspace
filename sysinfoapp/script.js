var fs = require('fs-extra');
var lodash = require('lodash');
var notefilename;
var json;
var whichNb = -1;
var sidenavOpn= 1;
var myapp = {
    open: function () {
        sidenavOpn = 1;
        document.getElementById("sidenav").style.width = "235px";
        document.getElementById("sidenav").children[1].style.width = "15%"; 
        document.getElementById("sidenav").children[1].children[1].style.visibility = "visible";   
        document.getElementById("sidenav").children[1].children[0].style.visibility = "hidden";
        var len = document.getElementById("sidenav").getElementsByTagName("a").length;
        for (let i = 0; i < len; i++) {
            document.getElementById("sidenav").getElementsByTagName("a").item(i).style.visibility = "visible";
        } //1
        document.getElementById("top-panel").style.visibility = "visible";
        
    },
    close: function () {
        sidenavOpn = 0;
        document.getElementById("sidenav").style.width = "25px";
        document.getElementById("sidenav").children[1].style.width = "100%";     
        document.getElementById("sidenav").children[1].children[0].style.visibility = "visible";   
        document.getElementById("sidenav").children[1].children[1].style.visibility = "hidden";
        var len = document.getElementById("sidenav").getElementsByTagName("a").length;
        for (let i = 0; i < len; i++) {
            document.getElementById("sidenav").getElementsByTagName("a").item(i).style.visibility = "hidden";
        }
        document.getElementById("top-panel").style.visibility = "hidden";
    },

    loadNotebook: function () {
        if(sidenavOpn == 0){
            this.open();
        }    
        fs.readFile('file.json', (err, data) => {
            if (err) {
                throw err;
            }
            json = JSON.parse(data.toString());            
            createListNotebooks();
        });    
    },
    save: function () {
        fs.writeFile(notefilename, document.getElementById("content-panel").innerHTML, (err) => {
            if (err)
                throw err;
            console.log("file saved");
        });
    },
    createNewEntry: function () {
        var node = document.createElement("Input");
        document.getElementById("sidenav-content").appendChild(node);
        node.addEventListener("blur", (ev) => {
            var tx = ev.target.value;
            if (whichNb != -1) {
                var newNo = {};
                newNo.Notename = tx;
                newNo.Content = 'notes/'+tx;
                json.Notebooks[whichNb].Notes[json.Notebooks[whichNb].Notes.length] = newNo; 
                createListOfNotes(whichNb);            

            } else {
                var newNb = {};
                newNb.Nbookname = tx;
                newNb.Notes = [];
                json.Notebooks[json.Notebooks.length] = newNb;               
                createListNotebooks();    

            }
            fs.writeFile("file.json", JSON.stringify(json)); 
            

        });
    }
}

function createListNotebooks() {
    removeAllChildNodes(document.getElementById("sidenav-content"));
    for (let i = 0; i < json.Notebooks.length; i++) {
        whichNb = -1;
        var node = createContentElement(json.Notebooks[i].Nbookname);
        node.addEventListener('click', (event) => createListOfNotes(i));
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

function createContentElement(name) {
    var node;
    if (name.length > 30) {
        shortName = name.substr(0, 28).concat("..");

        node = createChildNode(shortName, "a");
        node.addEventListener('mouseover', (event) => {
            node.appendChild(createChildNode(name, "span"));
        });
        node.addEventListener('mouseout', (event) => {
            removeAllChildNodes(node);
        });
    } else {
        node = createChildNode(name, "a");
    }
    return node;
}

function createChildNode(name, tag) {
    var textNode = document.createTextNode(name);
    var node = document.createElement(tag);
    node.appendChild(textNode);
    return node;
}

function createListOfNotes(i){
    removeAllChildNodes(document.getElementById("sidenav-content"));
    whichNb = i;
    for (let j = 0; j < json.Notebooks[i].Notes.length; j++) {                        
        var node = createContentElement(json.Notebooks[i].Notes[j].Notename);
        node.addEventListener('click', (event) => {
            notefilename = json.Notebooks[i].Notes[j].Content;
            fs.readFile(notefilename, (err, data) => {
                document.getElementById("content-panel").innerHTML = data;
            })
        });
        document.getElementById("sidenav-content").appendChild(node);
    }
}

//1.
//with lodash
// var collection = document.getElementById("sidenav").getElementsByTagName("a");
// lodash.forEach(collection , ( a => a.style.visibility = "visible"));