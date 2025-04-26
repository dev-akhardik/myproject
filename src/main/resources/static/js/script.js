const apiUrl = '/users'; // API URL for user operations

// Handle form submission
document.getElementById('userForm').addEventListener('submit', async e => {
  e.preventDefault();
  const name = document.getElementById('name').value;
  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;

  const res = await fetch(apiUrl, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ name, email, password })
  });

  if (res.ok) {
    alert('User added!');
    e.target.reset();
    loadUsers(); // Refresh the list of users after adding
  } else {
    alert('Error adding user');
  }
});

// Load users on button click
document.getElementById('loadBtn').addEventListener('click', loadUsers);

async function loadUsers() {
  const res = await fetch(apiUrl);
  const users = await res.json();
  const list = document.getElementById('userList');
  list.innerHTML = '';
  users.forEach(u => {
    const li = document.createElement('li');
    li.innerHTML = `${u.id}: ${u.name} (${u.email}) 
      <button onclick="updateUser(${u.id})">Update</button>
      <button onclick="deleteUser(${u.id})">Delete</button>`;
    list.append(li);
  });
}

// Update user
async function updateUser(userId) {
  const name = prompt("Enter new name:");
  const email = prompt("Enter new email:");
  const password = prompt("Enter new password:");

  const res = await fetch(`${apiUrl}/${userId}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ name, email, password })
  });

  if (res.ok) {
    alert('User updated!');
    loadUsers(); // Refresh the list of users after updating
  } else {
    alert('Error updating user');
  }
}

// Delete user
async function deleteUser(userId) {
  const res = await fetch(`${apiUrl}/${userId}`, {
    method: 'DELETE'
  });

  if (res.ok) {
    alert('User deleted!');
    loadUsers(); // Refresh the list of users after deletion
  } else {
    alert('Error deleting user');
  }
}