document.addEventListener("DOMContentLoaded", displayData);

function displayData (event) {
    let requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    let authorsContainer = document.getElementById('html-to-display');
    authorsContainer.innerHTML='';

    fetch("http://localhost:8080/api/data", requestOptions)
        .then(response => response.json())
        .then(data => {
            let row = document.createElement('tr');

            let ridesNumCol = document.createElement('td');
            let registeredUsersCol = document.createElement('td');

            ridesNumCol.textContent = data.publishedRides;
            registeredUsersCol.textContent = data.registeredUsers;

            row.appendChild(ridesNumCol);
            row.appendChild(registeredUsersCol);

            authorsContainer.appendChild(row);

        })

        .catch(error => console.log('error', error));
}
