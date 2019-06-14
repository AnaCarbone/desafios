var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var cards = lines[1].split(' ');
var resp = 0;
for(var i = (cards.length - 1); i > 0; i--) {

	if(parseInt(cards[i-1]) >= parseInt(cards[i])) {
  	resp ++;
  }
}
console.log(lines[0] - resp);
