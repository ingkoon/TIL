class User{
  constructor(id,password,email,location,phone) {
    this.id = id;
    this.password = password;
    this.email = email;
    this.location = location;
    this.phone = phone;
  }
}

function register() {
  let id = document.getElementById("main_register_id").value;
  let pw = document.getElementById("main_register_pw").value;
  let email = document.getElementById("main_register_email").value;
  let location = document.getElementById("main_register_location").value;
  let phone = document.getElementById("main_register_phone").value;
  let user = new User(id, pw, email, location, phone);
  registerUser(user);
}

function update() {
  let id = document.getElementById("main_user_info_id").value;
  let pw = document.getElementById("main_user_info_pw").value;
  let email = document.getElementById("main_user_info_email").value;
  let location = document.getElementById("main_user_info_location").value;
  let phone = document.getElementById("main_user_info_phone").value;
  let user = new User(id, pw, email, location, phone);
  updateUser(user);
}

function login() {
  let id = document.getElementById("main_login_id").value;
  let pw = document.getElementById("main_login_pw").value;
  loginUser(id, pw);
}

async function logout(){
	const url = "/whereismyhome/ajax/logout";
	  const options = {
	    method: "POST",
	    headers: {
	      "Content-Type": "application/json"
	    }
	  };

	  try {
	    const response = await fetch(url, options);

	    if (response.ok) {
	      alert("로그아웃 성공");
	      location.reload();
	    }
	  } catch (e) {
	    alert("로그아웃 실패");
	  }
}

function delete_() {
  let id = document.getElementById("main_user_info_id").value;
  let pw = document.getElementById("main_user_info_pw").value;
  deleteUser(id, pw);
}

async function loginUser(id, pw) {
  const url = "/whereismyhome/ajax/login";
  const options = {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({ login_id: id, login_pw: pw })
  };

  try {
    const response = await fetch(url, options);
    const user = await response.json();

    if (response.ok) {
      alert("로그인 성공");
      location.reload();
    } else {
      alert("로그인 실패");
    }
  } catch (e) {
    alert("로그인 실패");
  }
}

async function registerUser(user) {
  const url = "/whereismyhome/ajax/register";
  const options = {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(user)
  };

  const response = await fetch(url, options);
  if (response.ok) {
    alert("회원가입 성공");
    location.reload();
  } else {
    alert("회원가입 실패");
  }
}

async function updateUser(user) {
  const url = "/whereismyhome/ajax/update";
  const options = {
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(user)
  };

  const response = await fetch(url, options);
  if (response.ok) {
    alert("변경 성공");
    location.reload();
  } else {
    alert("변경 실패");
  }
}

async function deleteUser(id, pw) {
  const url = "/whereismyhome/ajax/delete";
  const options = {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({ login_id: id, login_pw: pw })
  };

  const response = await fetch(url, options);
  if (response.ok) {
    alert("삭제 성공");
    logout();
    location.reload();
  } else {
    alert("삭제 실패");
  }
}


function edit(id, id2) {
  document.getElementById(id).disabled = false;
  document.getElementById(id2).style.display = 'none';
}



