const password = document.getElementById('password');
const strengthBar = document.querySelector('#strength-bar div');

password.addEventListener('input', () => {
  const val = password.value;
  let strength = 0;

  if (val.length >= 6) strength += 20;
  if (/[A-Z]/.test(val)) strength += 20;
  if (/[0-9]/.test(val)) strength += 20;
  if (/[^A-Za-z0-9]/.test(val)) strength += 20;
  if (val.length >= 12) strength += 20;

  strengthBar.style.width = strength + '%';

  if (strength <= 40) strengthBar.style.background = 'red';
  else if (strength <= 60) strengthBar.style.background = 'orange';
  else if (strength <= 80) strengthBar.style.background = 'yellow';
  else strengthBar.style.background = '#00e600';
});