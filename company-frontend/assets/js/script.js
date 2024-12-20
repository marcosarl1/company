function fetchEmployees() {
    const tableBody = document.querySelector('#tableBody');
    while (tableBody.firstChild) {
        tableBody.removeChild(tableBody.firstChild);
    }
    fetch("http://localhost:8080/employee/list")
        .then(response => response.json())
        .then(data => {
            data.forEach(emp => {
                const row = document.createElement('tr');

                const cellChk = document.createElement('td');
                const formCheck = document.createElement('div');
                formCheck.className = "form-check"
                const checkbox = document.createElement("input");
                checkbox.type = 'checkbox';
                checkbox.className = 'form-check-input employee-checkbox';
                checkbox.dataset.id = emp.id;
                formCheck.appendChild(checkbox);
                cellChk.appendChild(formCheck);
                row.appendChild(cellChk);
                const cellId = document.createElement('td');
                cellId.textContent = emp.id;
                row.appendChild(cellId);
                const cellName = document.createElement('td');
                cellName.textContent = emp.name;
                row.appendChild(cellName);
                const cellCpf = document.createElement('td');
                cellCpf.textContent = emp.cpf;
                row.appendChild(cellCpf);
                const cellEmail = document.createElement('td');
                cellEmail.textContent = emp.email;
                row.appendChild(cellEmail);
                const cellPhone = document.createElement('td');
                cellPhone.textContent = emp.phone;
                row.appendChild(cellPhone);
                const cellSalary = document.createElement('td');
                cellSalary.textContent = emp.salary;
                row.appendChild(cellSalary);

                tableBody.appendChild(row)
            });
        });
}

document.getElementById('createForm').addEventListener('submit', function (event) {
    event.preventDefault();
    const employee = {
        name: document.getElementById('createName').value,
        cpf: document.getElementById('createCpf').value,
        email: document.getElementById('createEmail').value,
        phone: document.getElementById('createPhone').value,
        salary: document.getElementById('createSalary').value
    };
    fetch("http://localhost:8080/employee/create", {
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(employee)
    }).then(data => {
        event.target.reset();
        bootstrap.Modal.getInstance(document.getElementById('createModal')).hide();
        fetchEmployees()
    });
});

document.getElementById('selectAll').addEventListener('change', function (event) {
    const checkboxes = document.querySelectorAll('.employee-checkbox');
    checkboxes.forEach(checkbox => checkbox.checked = event.target.checked);
});

fetchEmployees();