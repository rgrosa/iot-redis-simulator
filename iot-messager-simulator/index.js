


(function loop() {
  setTimeout(function () {

    sendRequestToEnrichmentServer();

    loop()
  }, 2000); //9000 = 9000ms = 9s
}());


function sendRequestToEnrichmentServer(){

    var http = require('follow-redirects').http;
    var fs = require('fs');

    var options = {
      'method': 'POST',
      'hostname': 'localhost',
      'port': 8001,
      'path': '/iot-redis/enrichment-server/data',
      'headers': {
        'Content-Type': 'application/json'
      },
      'maxRedirects': 20
    };

    var req = http.request(options, function (res) {
      var chunks = [];

      res.on("data", function (chunk) {
        chunks.push(chunk);
      });

      res.on("end", function (chunk) {
        var body = Buffer.concat(chunks);
        console.log(body.toString());
      });

      res.on("error", function (error) {
        console.error(error);
      });
    });

    var postData = JSON.stringify({
                         "iotAgentId": generateRandomId(),
                         "iotAgentLocation": {
                           "latitude": generateRandomCoordinate(),
                           "longitude":  generateRandomCoordinate()
                         },
                         "isIotOn": generateRandomStatus()
                       });


    req.write(postData);

    req.end();
}

function generateRandomId(){
    const idList = [31341,12121]
    return idList[Math.floor(Math.random() * 2)]
}

function generateRandomCoordinate() {
    return (Math.random() * (180 - (-180)) + 180).toFixed(5) * 1;
}

function generateRandomStatus(){
    return Math.floor(Math.random() * 2) == 1 ? true : false;
}

