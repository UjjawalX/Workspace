document.getElementById("collapseable-btn")
.addEventListener("click", function () { 
    if(document.getElementById("collapseable-btn").classList.contains("open")){
        console.log("hi");document.getElementById("collapseable-btn").classList.remove("open");  
        document.querySelector("nav ul").classList.remove("open");

    } else {
        console.log("hi");document.getElementById("collapseable-btn").classList.add("open");  
        document.querySelector("nav ul").classList.add("open");
    }
});