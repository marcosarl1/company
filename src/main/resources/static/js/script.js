function fetchEmployees() {
    fetch("http://localhost:8080/employee/list")
        .then(response => response.json())
        .then(data => {
           const tableBody = document.querySelector('#tableBody');
           data.forEach(emp => {
              const row = document.createElement('tr');
              row.innerHTML = `
              <td>${emp.id}</td>
              <td>${emp.name}</td>
              <td>${emp.cpf}</td>
              <td>${emp.email}</td>
              <td>${emp.phone}</td>
              <td>${emp.salary}</td>
              `;
              tableBody.appendChild(row)
           });
        });
}

fetchEmployees();