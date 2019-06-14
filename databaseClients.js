var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var n = lines[0];
var used = [];
var j = 0;
var ex = false;

for (var i = 1; i <= n; i++) {
  var email = lines[i].split('@');
  email[0] = email[0].split('+')[0];
  
  while(email[0].indexOf('.') >= 0) {
  	email[0] = email[0].replace('.', '');
  }
	
  ex = false;
  for (j = 0; j < used.length; j++) {
    if (used[j][0] == email[0] && used[j][1] == email[1]) {
      ex = true;
      break;
    }
  }

  if (!ex) {
    used.push(email);
  }
}

console.log(used.length);
