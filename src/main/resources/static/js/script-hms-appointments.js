
// Array of doctors
const doctors = [
    { id: 1, name: 'Dr. John Barnes', specialty: 'Primary Care' },
    { id: 2, name: 'Dr. Jane Caldwell', specialty: 'Cardiology' },
    { id: 3, name: 'Dr. Peter Johnson', specialty: 'Pediatrics' },
    { id: 4, name: 'Dr. Adam Parker', specialty: 'Orthopedic' },
    { id: 5, name: 'Dr. Emily williams', specialty: 'Gynecology' },
    { id: 6, name: 'Dr. Adam Brown', specialty: 'Emergency Care' }
];

// Array to hold appointments
const appointments = [];

// Function to display the doctor list
function displayDoctorList() {
    const doctorList = document.getElementById('doctorList');
    const doctorSelect = document.getElementById('doctor');
    doctorList.innerHTML = '';
    doctorSelect.innerHTML = '';

    doctors.forEach(doctor => {
        const listItem = document.createElement('li');
        listItem.textContent = `${doctor.name} - ${doctor.specialty}`;
        doctorList.appendChild(listItem);

        const option = document.createElement('option');
        option.value = doctor.id;
        option.textContent = doctor.name;
        doctorSelect.appendChild(option);
    });
}

// Function to display the appointment list
function displayAppointmentList() {
    const appointmentList = document.getElementById('appointmentList');
    appointmentList.innerHTML = '';

    appointments.forEach(appointment => {
        const listItem = document.createElement('li');
        const doctor = doctors.find(doc => doc.id === appointment.doctorId);
        //listItem.textContent = `Patient: ${appointment.patientName}, Doctor: ${doctor.name}, Date: ${appointment.date}`;
        listItem.textContent = `${appointment.patientName} have an appointment with ${doctor.name} on  ${appointment.date}`;
        appointmentList.appendChild(listItem);
    });
}

// Function to schedule an appointment
function scheduleAppointment(event) {
    event.preventDefault(); // Prevent form submission

    const doctorId = parseInt(document.getElementById('doctor').value);
    const patientName = document.getElementById('patientName').value;
    const appointmentDate = document.getElementById('appointmentDate').value;

    const newAppointment = {
        doctorId: doctorId,
        patientName: patientName,
        date: appointmentDate
    };

    appointments.push(newAppointment);
    displayAppointmentList();

    // Clear the form
    document.getElementById('appointmentForm').reset();
}

// Set up event listeners
document.getElementById('appointmentForm').addEventListener('submit', scheduleAppointment);

// Display the initial doctor list
window.onload = displayDoctorList;
