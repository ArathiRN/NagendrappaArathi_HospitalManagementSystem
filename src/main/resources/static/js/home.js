
document.getElementById('registrationForm').addEventListener('submit', function(event) {
    event.preventDefault();

    // Create an array of form fields with validation regex patterns
    const formFields = [
        { id: 'firstName', value: document.getElementById('firstName').value, name: 'First Name', regex: null },
        { id: 'lastName', value: document.getElementById('lastName').value, name: 'Last Name', regex: null },
        { id: 'email', value: document.getElementById('email').value, name: 'Email', regex: /^[^\s@]+@[^\s@]+\.[^\s@]+$/ },
        { id: 'phone', value: document.getElementById('phone').value, name: 'Phone', regex: /^\d{10}$/ },
        { id: 'dob', value: document.getElementById('dob').value, name: 'Date of Birth', regex: /^\d{4}-\d{2}-\d{2}$/ }, // Assuming YYYY-MM-DD format
        { id: 'gender', value: document.getElementById('gender').value, name: 'Gender', regex: null },
        { id: 'address', value: document.getElementById('address').value, name: 'Address', regex: null }
    ];

    // Check if any fields are empty
    for (let field of formFields) {
        if (!field.value) {
            alert(`Fill out the ${field.name} field.`);
            return;
        }
        if (field.regex && !field.regex.test(field.value)) {
            alert(`Enter a valid ${field.name}.`);
            return;
        }
    }

    alert('Registration successful!');
});

/*
document.querySelector('h1').addEventListener('click', function () {
    alert('You clicked the heading!');
});*/

/*
function navigateToSection(page, sectionId) {
    window.location.href = `${page}#${sectionId}`;
}
*/