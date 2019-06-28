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
            var node = document.createElement("a");
            var textnode = document.createTextNode(json.Notebooks[0].Nbookname);
            node.appendChild(textnode);
            document.getElementById("sidenav-content").appendChild(node);
        });

    }

}