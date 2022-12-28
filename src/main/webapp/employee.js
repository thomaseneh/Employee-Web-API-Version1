document.getElementById("employeesForm").addEventListener("submit", function(event) {
    event.preventDefault();
    var name_on_form = document.getElementById("employeeName").value;
    var email_on_form = document.getElementById("employeeEmail").value;
    var department_on_form = document.getElementById("employeeDepartment").value;

    //object literal
    var employeeData = {
        name:name_on_form,
        email:email_on_form,
        department:department_on_form
    };

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){

        // 4 == "4"
        if(xhr.readyState === 4){
            var getData = JSON.parse(xhr.responseText)
            window.alert("success")
            dataTable(getData);
        }
    }
    xhr.open("POST", "/employeesWebAPI/employee/api")
    xhr.send(JSON.stringify(employeeData));
});

function dataTable(pojo){
    var tr = document.createElement("tr");
    var id = document.createElement("td");
    var name = document.createElement("td");
    var email = document.createElement("td");
    var department = document.createElement("td");

    id.innerText = pojo.id;
    name.innerText = pojo.name;
    email.innerText = pojo.email;
    department.innerText = pojo.department;

    tr.appendChild(id);
    tr.appendChild(name);
    tr.appendChild(email);
    tr.appendChild(department);
    document.getElementById("employeeTable").appendChild(tr);
}

    window.onload = function(pojo){
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function(response){
            if(xhr.readyState === 4){
                var data = JSON.parse(xhr.responseText)
                data.forEach(pojo => {
                    dataTable(pojo);
                });
            }
        }
        xhr.open("GET", "/employeesWebAPI/employee/api")
        xhr.send(pojo)
    };