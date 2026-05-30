//task-1
console.log("Welcome to the Community Portal")
//task-2
const eventName = 'Musical Night';
const eventDate = '2026-06-15'
let seats = 50;

console.log(`$event name:${eventName}
    event date: ${eventDate}
    remaining seats:${seats}`)

//can be placed in register form
seats--;
seats++;

sessionStorage.setItem("lastVisit", new Date());
const events = [
    { name: "Summer Swimming Fest", date: "2025-05-29", entryfee: 0 ,seats:100,location:"cvr college"},
    { name: "Music Night Live", date: "2025-06-05", entryfee: 150,seats:120 ,location:"cvr college"},
    { name: "Food & Culture Fair", date: "2025-06-12", entryfee: 50,seats:250,location:"cvr college" },
    { name: "Yoga & Wellness Camp", date: "2025-06-20", entryfee: 100 ,seats:300,location:"cvr college"},
    { name: "Tech Hackathon", date: "2025-07-01", entryfee: 200 ,seats:40,location:"cvr college"},
    { name: "Kids Art Workshop", date: "2025-07-10", entryfee: 75,seats:0 ,location:"cvr college"},
];


//adding events to page
const eventGallery=document.getElementById('event-gallery-cards')
events.forEach(event=>{

    if(new Date(event.date)<=new Date()){
        console.log('Event expired');
        return;
    }
    else if(event.seats==0){
        console.log('Event full');
        return;
    }

    eventGallery.innerHTML+=`<div class="event-gallery-card">
        <img class="gallery-img" title="summer-event" width="200px" height="130px"
                src="src/122-600x300.jpg" alt="event-image">
                <p id="event-title">${event.name}</p>
                <div style="display: flex;justify-content: center;align-items: center;">
                    <p id="event-location">${event.location} <span></span></p>
                    <p id="event-date">${event.date}</p>
                </div>
        </div>`
})

function showConfirmation() {
    console.log("Submit button clicked");
}

//  window.addEventListener('load',()=>{
//     const event = localStorage.getItem('event')
//     if(!event) return;
//     const preference = events.find(e=>e.name==event)
//     document.getElementById('feedback-event').value=preference?.name;
//  })

window.onload = () => {

    //js task
    //alert("page is fully loaded!")
    
    //code from html module
    const event = localStorage.getItem('event')
    if (!event) return;
    const preference = events.find(e => e.name == event)
    document.getElementById('preference-event').value = preference?.name;
    document.getElementById('preference-msg').style.visibility = 'visible'
    console.log("Restored preference:", event);
}

//validate phone number on lossing focus .
function validatePhone() {
    const phoneNumber = document.getElementById("phone-number").value.trim()
    const warning = document.getElementById('invalid-msg')
    const REGEX_PHONE = /^\d{10}$/;
    if (phoneNumber.length == 0) {
        warning.style.visibility = 'hidden';
        return;
    }
    if (phoneNumber.length < 10) {
        warning.style.visibility = 'visible';
        return;
    }
    else if (!REGEX_PHONE.test(phoneNumber)) {
        warning.style.visibility = 'visible';
        return;
    }
    warning.style.visibility = 'hidden';
}


function handleFeedbackSubmit() {
    document.getElementById('feedback-msg').textContent =
        'Feedback submitted successfully!';
    document.getElementById("feedback-form").reset();
    document.getElementById('fee-msg').style.visibility = 'hidden'
    document.getElementById('feedback-textarea-charcount').textContent = '0/1000';
}
//display event fee based on event change
function handleEventChange() {
    const event = document.getElementById('feedback-event').value.trim();
    const message = document.getElementById('fee-msg')
    console.log("Selected event:", event);
    if (!event) {
        message.style.visibility = 'hidden';
        message.textContent = '';
        return;
    }
    const resEvent = events.find(e => e.name == event);
    if (!resEvent) return;
    const fee = resEvent.entryfee;
    message.textContent = `Entry fee - ${fee}`;
    message.style.visibility = 'visible';
}

function handleEventSubmit(e) {
    try{
    e.preventDefault();
    const formElement = document.getElementById('register-form');
    const formData = new FormData(e.target);
    const element = document.getElementById('registration-msg');
    //console.log(formData.get('name'))
    element.textContent = 'registeration completed sucessfully!'
    console.log("Registration submitted");
    console.log("Name:", formData.get('name'));
    console.log("Email:", formData.get('usermail'));
    formElement.reset();
    }
    catch(error){
        console.error(error);
        document.getElementById('registration-msg').textContent =
            'Registration failed';
    }
}

//functions enlarge the image on double click and v-v
function enlargeImage() {
    const img = document.getElementById('feedback-img')
    const isEnlarged = img.dataset.enlarged;
    if (isEnlarged==="false") {
        img.style.width = '250px';
        img.style.height = '150px';
        img.dataset.enlarged = 'true';
    }
    else {
        img.style.width = '200px';
        img.style.height = '120px';
        img.dataset.enlarged = 'false'
    }
}


//counts the characters in text area dynamically while typing
function countCharacters(e) {
    const content = document.getElementById('feedback-textarea')
    const element = document.getElementById('feedback-textarea-charcount')
    element.textContent = `${content.value.length}/1000`;
}

//display msg when video is loaded and ready to play
function handleVideoMessage() {
    const element = document.getElementById('video-play-message')
    element.style.visibility = 'visible'
}

//this is blocked by browser
//onbeforeunload = (e)=>alert('Are you sure to leave the site?')
//window.addEventListener('beforeunload',alert('Are you sure to leave the site?'))

//set preference in local storage
function handlePreferenceChange() {
    const event = document.getElementById('preference-event').value.trim()
    localStorage.setItem('event', event)
    console.log("Preference saved:", event);
}
//clears preference from local storage
function clearPreference() {
    const event = document.getElementById('preference-event').value = '';
    document.getElementById('preference-msg').style.visibility = 'hidden'
    localStorage.clear();
    sessionStorage.clear();
}

const options = {
    timeout: 5000,//request timeouts in 5s
    enableHighAccuracy: true,//high accuracy mode
    maxAge: 0//always uses current values ,not caches
}
function success(position) {
    const cord = position.coords;
    console.log("Location fetched:", position.coords);
    const { latitude, longitude, accuracy } = cord
    document.getElementById('location-info').innerHTML = `
            <div><strong>Location found!</strong></div>
            <div>Latitude: <span class="coord">${latitude}°</span></div>
            <div>Longitude:<span class="coord">${longitude}°</span></div>
            <div>Accuracy:<span class="coord">${accuracy}</span></div>
            `
}
function err(error) {
    console.error("Geolocation error:", error);
    let msg = '';
    switch (error.code) {
        case error.PERMISSION_DENIED:
            msg = 'Location access denied. Please allow location permission in your browser.';
            break;
        case error.POSITION_UNAVAILABLE:
            msg = 'Location information unavailable.Try again later.'; break;
        case error.TIMEOUT:
            msg = 'Location request timed out (5s).Check your connection and retry.';
            break;
        default:
            msg = 'An unknown error occurred.';
    }
    document.getElementById('location-info').innerHTML = `<span class="geo-error">${msg}</span>`;
}


//function to get users current coords 
function fetchCoordinates() {
    //takes callbacks 1.success 2.failure 3.options(object)
    navigator.geolocation.getCurrentPosition(success, err, options)
}