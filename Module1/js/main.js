// TASK 1
console.log("Welcome to the Community Portal");
// window.onload = () => {
//     alert("Page is fully loaded!");
// };


//task-2
const eventName = 'Musical Night';
const eventDate = '2026-06-15';
let seats = 50;

console.log(`event name: ${eventName}
    event date: ${eventDate}
    remaining seats: ${seats}`);

// Task 2: -- and ++ for seat management
seats--;  // someone registered
seats++;  // someone cancelled


// TASK 2: Session storage - last visit
sessionStorage.setItem("lastVisit", new Date());

// TASK 5 - Event class with prototype method
class Event {
    constructor({ name, date, entryfee, seats, location, category }) {
        this.name = name;
        this.date = date;
        this.entryfee = entryfee;
        this.seats = seats;
        this.location = location;
        this.category = category || "general";
    }
}

// Task 5: checkAvailability on prototype
Event.prototype.checkAvailability = function () {
    if (new Date(this.date) <= new Date()) return "expired";
    if (this.seats === 0) return "full";
    return "available";
};

// EVENT DATA - using Task 5 Event class
const events = [
    new Event({ name: "Summer Swimming Fest", date: "2025-05-29", entryfee: 0,   seats: 100, location: "cvr college", category: "sports" }),
    new Event({ name: "Music Night Live",     date: "2026-06-05", entryfee: 150, seats: 120, location: "cvr college", category: "music" }),
    new Event({ name: "Food & Culture Fair",  date: "2026-06-12", entryfee: 50,  seats: 250, location: "cvr college", category: "culture" }),
    new Event({ name: "Yoga & Wellness Camp", date: "2026-06-20", entryfee: 100, seats: 300, location: "cvr college", category: "wellness" }),
    new Event({ name: "Tech Hackathon",       date: "2026-07-01", entryfee: 200, seats: 40,  location: "cvr college", category: "tech" }),
    new Event({ name: "Kids Art Workshop",    date: "2026-07-10", entryfee: 75,  seats: 0,   location: "cvr college", category: "art" }),
];

// Task 5
console.log("Event properties (Object.entries):");
Object.entries(events[1]).forEach(([key, value]) => {
    console.log(`  ${key}: ${value}`);
});


// TASK 4 - Functions, Scope, Closures, Higher-Order Functions

// Task 4: addEvent() - adds a new event to the array
function addEvent(eventObj) {
    const newEvent = new Event(eventObj);
    events.push(newEvent);
    console.log(`Event added: ${newEvent.name}`);
    renderEventGallery(); 
    return newEvent;
}

// Task 4: registerUser() - registers user for an event
function registerUser(userName, eventName) {
    try {
        const found = events.find(e => e.name === eventName);
        if (!found) throw new Error(`Event "${eventName}" not found.`);
        if (found.checkAvailability() !== "available") {
            throw new Error(`Event "${eventName}" is not available.`);
        }
        found.seats--;
        console.log(`${userName} registered for ${eventName}. Seats left: ${found.seats}`);
        return true;
    } catch (err) {
        console.error("registerUser error:", err.message);
        return false;
    }
}

// Task 4: Closure to track total registrations per category
function makeRegistrationTracker() {
    const categoryCount = {};
    return function track(category) {
        categoryCount[category] = (categoryCount[category] || 0) + 1;
        console.log(`Category registrations:`, categoryCount);
        return categoryCount[category];
    };
}
const trackRegistration = makeRegistrationTracker();

// Task 4: filterEventsByCategory()
function filterEventsByCategory(category, callback) {
    // Task 10: spread operator to clone before filtering
    const cloned = [...events];
    const filtered = cloned.filter(e => e.category === category);
    //if (typeof callback === 'function') 
    callback(filtered);
    return filtered;
}


// Task 6: .filter() - only music events
const musicEvents = events.filter(e => e.category === "music");
console.log("Music events:", musicEvents.map(e => e.name));

// Task 6: .map() - format display labels
const formattedCards = events.map(e => `${e.category.charAt(0).toUpperCase() + e.category.slice(1)} on ${e.date}: ${e.name}`);
console.log("Formatted event cards:", formattedCards);

// Task 6: .push() demonstrated via addEvent()



// TASK 7 - DOM Manipulation: render events using createElement()
function renderEventGallery(list) {
    const eventGallery = document.getElementById('event-gallery-cards');
    // Task 7: use querySelector()
    const searchInput = document.querySelector('#event-search');
    const searchTerm = searchInput ? searchInput.value.toLowerCase() : '';

    const source = list || events;
    eventGallery.innerHTML = '';

    // Task 3: forEach loop + if-else to filter past/full events
    source.forEach(event => {
        if (event.checkAvailability() === "expired") {
            console.log(`Event expired: ${event.name}`);
            return;
        }
        if (event.checkAvailability() === "full") {
            console.log(`Event full: ${event.name}`);
            return;
        }


        if (searchTerm && !event.name.toLowerCase().includes(searchTerm)) return;

        // Task 7: createElement 
        const card = document.createElement('div');
        card.className = 'event-gallery-card';

        const img = document.createElement('img');
        img.className = 'gallery-img';
        img.title = event.name;
        img.width = 200;
        img.height = 130;
        img.src = 'src/122-600x300.jpg';
        img.alt = 'event-image';

        const title = document.createElement('p');
        title.textContent = event.name;

        const meta = document.createElement('div');
        meta.style.cssText = 'display:flex;justify-content:center;align-items:center;gap:6px;';

        const loc = document.createElement('p');
        loc.textContent = event.location;

        const date = document.createElement('p');
        date.textContent = event.date;

        const fee = document.createElement('p');
        fee.textContent = event.entryfee === 0 ? 'Free' : `₹${event.entryfee}`;
        fee.style.cssText = 'font-size:11px;color:#2563eb;font-weight:bold;';

        const regBtn = document.createElement('button');
        regBtn.textContent = 'Register';
        regBtn.style.cssText = 'margin-top:6px;font-size:12px;padding:5px 10px;';
        // Task 8: onclick for Register button
        regBtn.onclick = () => {
            const name = prompt(`Enter your name to register for "${event.name}":`);
            if (!name) return;
            const success = registerUser(name, event.name);
            if (success) {
                trackRegistration(event.category);
                alert(`Registered successfully for ${event.name}!`);
                renderEventGallery();  // Task 7: update UI after register
            } else {
                alert("Registration failed. Check console for details.");
            }
        };

        meta.appendChild(loc);
        meta.appendChild(date);
        card.appendChild(img);
        card.appendChild(title);
        card.appendChild(meta);
        card.appendChild(fee);
        card.appendChild(regBtn);

        eventGallery.appendChild(card);
    });
}


// ============================================================
// TASK 9 - Async JS: Fetch events from mock API
// ============================================================

// Task 9: Using JSONPlaceholder as mock endpoint
async function fetchEventsFromAPI() {
    const spinner = document.getElementById('api-spinner');
    const apiOutput = document.getElementById('api-output');
    if (spinner) spinner.style.display = 'block';
    if (apiOutput) apiOutput.textContent = 'Loading events...';

    try {
        // Task 9: async/await
        const response = await fetch('https://jsonplaceholder.typicode.com/posts?_limit=3');
        if (!response.ok) throw new Error(`HTTP error: ${response.status}`);
        const data = await response.json();

        if (apiOutput) {
            apiOutput.innerHTML = '<strong>Mock API events loaded:</strong><br>' +
                data.map(d => `• ${d.title.slice(0, 50)}...`).join('<br>');
        }
        console.log("API events fetched:", data);
    } catch (err) {
        // Task 9: .catch equivalent in try-catch
        console.error("Fetch error:", err);
        if (apiOutput) apiOutput.textContent = 'Failed to load events from API.';
    } finally {
        if (spinner) spinner.style.display = 'none';
    }
}

// Task 9:  demonstrate .then()/.catch() style
function fetchEventsPromiseStyle() {
    fetch('https://jsonplaceholder.typicode.com/posts?_limit=2')
        .then(res => res.json())
        .then(data => console.log("Promise-style fetch result:", data))
        .catch(err => console.error("Promise fetch error:", err));
}


// TASK 10 - Modern JS: destructuring, spread, default params

// Task 10: default parameter
function getEventSummary(event, currency = '₹') {
    // Task 10: destructuring
    const { name, date, entryfee, seats, category } = event;
    return `[${category.toUpperCase()}] ${name} | ${date} | Fee: ${entryfee === 0 ? 'Free' : currency + entryfee} | Seats: ${seats}`;
}

// Task 10: spread to clone and sort without mutating original
const sortedByDate = [...events].sort((a, b) => new Date(a.date) - new Date(b.date));
console.log("Events sorted by date (spread clone):", sortedByDate.map(e => e.name));
console.log("Sample summary:", getEventSummary(events[1]));

// TASK 12 - AJAX & Fetch API: POST registration + setTimeout
async function postRegistration(userData) {
    const msgEl = document.getElementById('registration-msg');
    if (msgEl) msgEl.textContent = 'Submitting registration...';

    try {
        // Task 12: fetch POST to mock endpoint
        const response = await fetch('https://jsonplaceholder.typicode.com/posts', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(userData),
        });
        const result = await response.json();
        console.log("POST response:", result);

        // Task 12: setTimeout to simulate delay before showing success
        setTimeout(() => {
            if (msgEl) msgEl.textContent = `Registration submitted! (ID: ${result.id})`;
        }, 1000);

    } catch (err) {
        console.error("POST error:", err);
        if (msgEl) msgEl.textContent = 'Registration failed. Please try again.';
    }
}



window.onload = () => {
    // Task 1: alert on page load
    alert("Page is fully loaded!");

    // Task 3/7: render gallery
    renderEventGallery();

    // Task 9: auto-fetch from mock API
    fetchEventsFromAPI();
    fetchEventsPromiseStyle();

    // Restore preference from localStorage
    const savedEvent = localStorage.getItem('event');
    if (savedEvent) {
        const prefSelect = document.getElementById('preference-event');
        if (prefSelect) prefSelect.value = savedEvent;
        const prefMsg = document.getElementById('preference-msg');
        if (prefMsg) prefMsg.style.visibility = 'visible';
        console.log("Restored preference:", savedEvent);
    }
};


// ============================================================
// TASK 8 - Event Handling: keydown search
// ============================================================
document.addEventListener('DOMContentLoaded', () => {
    const searchInput = document.querySelector('#event-search');
    if (searchInput) {
        // Task 8: keydown for quick search
        searchInput.addEventListener('keydown', (e) => {
            setTimeout(() => renderEventGallery(), 50);
        });
    }

    // Task 8: onchange for category filter dropdown
    const categoryFilter = document.querySelector('#category-filter');
    if (categoryFilter) {
        categoryFilter.addEventListener('change', () => {
            const selected = categoryFilter.value;
            if (!selected) {
                renderEventGallery();
            } else {
                filterEventsByCategory(selected, (filtered) => {
                    renderEventGallery(filtered);
                });
            }
        });
    }
});

function showConfirmation() {
    console.log("Submit button clicked");
}

function validatePhone() {
    const phoneNumber = document.getElementById("phone-number").value.trim();
    const warning = document.getElementById('invalid-msg');
    const REGEX_PHONE = /^\d{10}$/;
    if (phoneNumber.length === 0) {
        warning.style.visibility = 'hidden';
        return;
    }
    warning.style.visibility = REGEX_PHONE.test(phoneNumber) ? 'hidden' : 'visible';
}

function handleFeedbackSubmit() {
    document.getElementById('feedback-msg').textContent = 'Feedback submitted successfully!';
    document.getElementById("feedback-form").reset();
    document.getElementById('fee-msg').style.visibility = 'hidden';
    document.getElementById('feedback-textarea-charcount').textContent = '0/1000';
}

function handleEventChange() {
    const eventVal = document.getElementById('feedback-event').value.trim();
    const message = document.getElementById('fee-msg');
    if (!eventVal) {
        message.style.visibility = 'hidden';
        message.textContent = '';
        return;
    }
    const resEvent = events.find(e => e.name === eventVal);
    if (!resEvent) return;
    message.textContent = `Entry fee - ${resEvent.entryfee === 0 ? 'Free' : '₹' + resEvent.entryfee}`;
    message.style.visibility = 'visible';
}

// Task 3/12: handleEventSubmit now calls postRegistration
function handleEventSubmit(e) {
    try {
        e.preventDefault();
        const formData = new FormData(e.target);
        const userData = {
            name: formData.get('name'),
            email: formData.get('usermail'),
            date: formData.get('eventdate'),
            message: formData.get('message'),
        };
        console.log("Registration submitted:", userData);

        // Task 12: POST to mock API
        postRegistration(userData);

        document.getElementById('register-form').reset();
    } catch (error) {
        console.error(error);
        document.getElementById('registration-msg').textContent = 'Registration failed';
    }
}

function enlargeImage() {
    const img = document.getElementById('feedback-img');
    const isEnlarged = img.dataset.enlarged;
    if (isEnlarged === "false") {
        img.style.width = '250px';
        img.style.height = '150px';
        img.dataset.enlarged = 'true';
    } else {
        img.style.width = '200px';
        img.style.height = '120px';
        img.dataset.enlarged = 'false';
    }
}

function countCharacters() {
    const content = document.getElementById('feedback-textarea');
    const element = document.getElementById('feedback-textarea-charcount');
    element.textContent = `${content.value.length}/1000`;
}

function handleVideoMessage() {
    document.getElementById('video-play-message').style.visibility = 'visible';
}

function handlePreferenceChange() {
    const event = document.getElementById('preference-event').value.trim();
    localStorage.setItem('event', event);
    console.log("Preference saved:", event);
}

function clearPreference() {
    document.getElementById('preference-event').value = '';
    document.getElementById('preference-msg').style.visibility = 'hidden';
    localStorage.clear();
    sessionStorage.clear();
}

const geoOptions = {
    timeout: 5000,
    enableHighAccuracy: true,
    maxAge: 0,
};

function success(position) {
    // Task 10: destructuring
    const { latitude, longitude, accuracy } = position.coords;
    console.log("Location fetched:", position.coords);
    document.getElementById('location-info').innerHTML = `
        <div><strong>Location found!</strong></div>
        <div>Latitude: <span class="coord">${latitude}°</span></div>
        <div>Longitude: <span class="coord">${longitude}°</span></div>
        <div>Accuracy: <span class="coord">${accuracy}m</span></div>
    `;
}

function err(error) {
    console.error("Geolocation error:", error);
    let msg = '';
    switch (error.code) {
        case error.PERMISSION_DENIED:
            msg = 'Location access denied. Please allow location permission in your browser.'; break;
        case error.POSITION_UNAVAILABLE:
            msg = 'Location information unavailable. Try again later.'; break;
        case error.TIMEOUT:
            msg = 'Location request timed out (5s). Check your connection and retry.'; break;
        default:
            msg = 'An unknown error occurred.';
    }
    document.getElementById('location-info').innerHTML = `<span class="geo-error">${msg}</span>`;
}

function fetchCoordinates() {
    navigator.geolocation.getCurrentPosition(success, err, geoOptions);
}
