// This is a thing.
// Heck.

var storyDiv = document.getElementById('storyDiv');
var choices = document.getElementById('choices');

function addButtons(name, id) {
  var newButton = document.createElement('input');
  newButton.setAttribute('type', 'button');
  newButton.setAttribute('value', name);
  newButton.id = id;
  choices.appendChild(newButton);
}

function clearDiv(input) {
  input.innerHTML = "";
}

function changeHTML(input, HTMLtext) {
  input.innerHTML += HTMLtext;
}

addButtons("Start",'start');

start.addEventListener('click', function(e){
  begin();
})

function begin(){
  storyDiv.textContent= "You awake sitting in a chair and a splitting head ache. There is food on the table.";
  clearDiv(choices);
  var newDiv = ('div')
  changeHTML(newDiv, '<input type="text" name="Cry" value="Cry" id="choice1"/>\
                      <input type="text" name="Consume" value="Consume" id="choice2"/>\
                      <input type="text" value="Fight" value="Fight" id="choice3"/>'
                    );
}
