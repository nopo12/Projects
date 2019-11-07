var html = undefined;
const getURL = function (url) {
    const request = require('request');
    url = url.replace(/['";]+/g, '');
    console.log(url);
    request(url, (err, res, body) => {
        if (err) {
            return console.log(err);
        }
        html = body;
    });
};

let b = getURL("http://helpful-helium.glitch.me");
sleep(3000);
//this will run first so 'b' will be undefined
console.log(b);

