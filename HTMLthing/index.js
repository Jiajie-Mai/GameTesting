// This is a thing.
// Heck.

var storyDiv = document.getElementById('storyDiv');
var choices = document.getElementById('choices');
var parser = new DOMParser();
var xmlDoc = parser.parseFromString(text,"resources/text.xml");

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

function clearAll() {
  clearDiv(storyDiv);
  clearDiv(choices);
}

function changeHTML(input, HTMLtext) {
  input.innerHTML += HTMLtext;
}

addButtons("Start",'start');
//storyDiv.textContent += xmlDoc.getElementsByTagName("items")

start.addEventListener('click', function(e){
  begin();
})

function begin(){
  storyDiv.textContent= "You awake sitting in a chair and a splitting head ache. There is food on the table.";
  clearDiv(choices);
  addButtons("Consume",'choice1');
  addButtons("Cry",'choice2');
  addButtons("Punch",'choice3');
  addButtons("Die",'choice4');


  choice1.addEventListener('click',function(e){
    clearAll();
    storyDiv.innerHTML = "You consumed the food, instantly regaining some strength.";
    addButtons("OK",'choice1');
    choice1.addEventListener('click',function(e){
      //something
    })
  });
  choice2.addEventListener('click',function(e){
    clearAll();
    storyDiv.innerHTML = "You start analyzing your situation, realizing there is no point to life and start crying. You continue, eyes red, until you run out of liquids and die.<br><br>THE END";
    addButtons("Back from beginning?",'choice1');
    choice1.addEventListener('click',function(e){
      begin();
    })
  });
  choice3.addEventListener('click',function(e){
    clearAll();
    storyDiv.innerHTML = "You try and punch something but end up hitting your own face. You die in your weakened state.<br><br>THE END";
    addButtons("Back from beginning?",'choice1');
    choice1.addEventListener('click',function(e){
      begin();
    })
  });
  choice4.addEventListener('click',function(e){
        clearAll();
    storyDiv.innerHTML = "You died.<br><br>That was it. Expected something else?";
    addButtons("Back from beginning?",'choice1');
    choice1.addEventListener('click',function(e){
      begin();
    })
  })
}
