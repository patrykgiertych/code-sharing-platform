function register() {
    let object = {
        "username": document.getElementById("username").value,
        "password": document.getElementById("password").value
    };

    let json = JSON.stringify(object);
    let xhr = new XMLHttpRequest();
    xhr.open("POST", '/api/user/new', false)
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);

    if (xhr.status != 200) {
        alert("Something went wrong!");
    } else if (xhr.status == 200){
        alert("Success!");
    }
}