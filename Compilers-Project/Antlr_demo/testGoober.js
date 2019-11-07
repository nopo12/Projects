const getURL = function (url) {
    let html;
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
console.log("a");
