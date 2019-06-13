var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var a = lines[1].split(' ');
var h = {
	'0': 0
};
var t = 0;
var d = 0;

for(var i = 0; i < a.length - 1; i++) {
	t += parseInt(a[i]);
  h[t] = i+1;
}


t+= parseInt(a[a.length - 1]);

d = t/2;

var r = 0;
for(var key in h) {
	var kv = parseInt(key);
  if(kv >= d) {
  	break;
  }
  
  if(typeof(h[kv+d]) !== "undefined") {
  	r++;
    if(r == 2) break;
  }
}

var resp = r == 2 ? 'Y' : 'N';
console.log(resp)
