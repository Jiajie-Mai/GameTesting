

var storyDiv = document.getElementById("storyDiv");
var choices = document.getElementById("choices");

function addButtons() {
  var newButton = document.createElement("input");
  newButton.setAttribute("type", "button");
  newButton.setAttribute("value", "Start");
  newButton.setAttribute("name", "start");
  document.body.appendChild(newButton);
}

addButtons()

Start.addEventListener("click", function(e){
  storyDiv.innerHTML = "No.";
})
