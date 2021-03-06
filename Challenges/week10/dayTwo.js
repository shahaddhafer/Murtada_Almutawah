function bin2dec(str) {
  let res = 0;
  // your code here
  count = 0;
  for (let i = str.length - 1; i > 0; i--) {
    let power = 2 ** count;
    if (str[i] == 1) {
      res += power;
    } else if (str[i] == "b") {
      break;
    }
    // console.log(str[i], power);
    count++;
  }
  return res;
}
console.log(bin2dec("0b1101"));
// this should return 13
console.log(bin2dec("0b11111111"));
console.log(bin2dec("0b1111111111111111111111111111111111111111111111111111111111111111"));

// Hex to dec
function hex2dec(str) {
  let res = 0;
  // your code here
  str = str.toUpperCase();
  count = 0;
  for (let i = str.length - 1; i >= 0; i--) {
    let value = 0;
    if (str[i] === "x") {
      break;
    } else if (isNaN(str[i])) {
      // console.log(i, str[i]);
      str[i] === "A"
        ? (value = 10)
        : str[i] === "B"
        ? (value = 11)
        : str[i] === "C"
        ? (value = 12)
        : str[i] === "D"
        ? (value = 13)
        : str[i] === "E"
        ? (value = 14)
        : str[i] === "F"
        ? (value = 15)
        : "";
    } else {
      value = str[i];
    }
    let power = 16 ** count;
    res += power * value;
    // console.log(str[i], power);
    count++;
  }
  return res;
}

console.log(hex2dec("0x3A"));
console.log(hex2dec("0xE3"));
console.log(hex2dec("0xFF"));
console.log(hex2dec("0xFFFFFFFFFFFFFFFF"));

// dec to hex

hexValue = "0123456789abcdef";

function dec2hex(num) {
  let res = "0x";

  let power = Math.floor(Math.log(num) / Math.log(16));

  while (power > 0) {
    let val = Math.floor(num / Math.pow(16, power));
    res += hexValue[val];
    num %= Math.pow(16, power);
    power--;
  }

  res += num;

  return res;
}

console.log(dec2hex(1000));
console.log(dec2hex(4096));
console.log(hex2dec(dec2hex(4096)));
console.log(hex2dec(dec2hex(1000)));
