const antlr4 = require('antlr4');
const GoobScraperVisitor = require('./lib/GoobScraperVisitor').GoobScraperVisitor;
/**constructor*/
let GoobVisitor = function(){
    // inherit default visitor
    GoobScraperVisitor.call(this);
    return this;
};
// have prototype "extend" SimpleMathVisitor, and then "override" functions
GoobVisitor.prototype = Object.create(GoobScraperVisitor.prototype);
GoobVisitor.prototype.constructor = GoobVisitor;
//a map in JavaScript
//CalculatorVisitor.prototype.memory= new Map();
 /*Functions for each expression:*/
GoobVisitor.prototype.visitGetURL = function(ctx) {
    //var value = this.visit(ctx.visitGetURL());
    let url = ctx.word().getText().replace(/\"/g, "");
    //var value = this.visit(ctx.word().getText());
    console.log("Value is : " + url);
    return url;
};


GoobVisitor.prototype.visitGetTable = function(ctx) {
    //var value = this.visit(ctx.visitGetURL());
    let url = ctx.word().getText().replace(/\"/g, "");
    //var value = this.visit(ctx.word().getText());
    let html = "<!DOCTYPE html>\n" +
        "<html lang=\"en\">\n" +
        "  <head>\n" +
        "    <title>Your Name Here</title>\n" +
        "    <meta charset=\"utf-8\">\n" +
        "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
        "    <link rel=\"stylesheet\" href=\"/style.css\" type=\"text/css\">\n" +
        "    <link rel=\"stylesheet\" href=\"/media-queries.css\" type=\"text/css\">\n" +
        "    <link href=\"https://fonts.googleapis.com/css?family=Cookie\" rel=\"stylesheet\">\n" +
        "    <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" crossorigin=\"anonymous\" />\n" +
        "  </head>  \n" +
        "\n" +
        "  <body>\n" +
        "    <h2>What's your  name, Hacker? hfuyivcfyddut</h2>\n" +
        "    \n" +
        "    <section class=\"asd\"> <p class=\"ert\">\n" +
        "      adsfsgsdg\n" +
        "      </p>\n" +
        "      das;jklf;adsjk;lfasdk;ljewqrnmcxzadsjkl;fqwernmqe,rxzadsjfk;lajksd;we2asd\n" +
        "    </section>\n" +
        "    <p>\n" +
        "      Shalooooooooom!!!!!!!<strong>!!!!!!!</strong>!!!!!!!!!!!!!!!!!!!!!!!!!!\n" +
        "    </p>\n" +
        "    <p>\n" +
        "      <table>\n" +
        "        <tr> <td>10</th> <td>20</td> <td>30</td>   <td>40</td> <td>50</td>  <td>60</td>  </tr>\n" +
        "        <tr> <td>11</td>  <td>21</td> <td></td>  <td>41</td>   <td>51</td>   <td>61</td>   </tr>\n" +
        "        <tr> <td>12</td>  <td>22</td>  <td>32</td> <td>42</td>  <td>52</td>    <td>62</td>   </tr>\n" +
        "        <tr> <td>13</td> <td>23</td>  <td>33</td> <td>43</td>  <td>53</td>      </tr>\n" +
        "        <tr> <td>14</td>  <td>24</td>  <td>34</td> <td>44</td>  <td>54</td>                 </tr>\n" +
        "    </table>\n" +
        "      <!--\n" +
        "        <tr> <th>ראובן</th> <th>שמעון</th> <th>לוי</th>   <th>יהודה</th> <th>יששכר</th>  <th>זבולון</th>  </tr>\n" +
        "        <tr> <td>חנוך</td>  <td>ימואל</td> <td>קהת</td>  <td>ער</td>   <td>תולה</td>   <td>סרד</td>   </tr>\n" +
        "        <tr> <td>פלוא</td>  <td>ימין</td>  <td>גרשון</td> <td>עונן</td>  <td>פוה</td>    <td>אלון</td>   </tr>\n" +
        "        <tr> <td>חצרון</td> <td>אוהד</td>  <td>מררי</td> <td>שלה</td>  <td>יוב</td>    <td>יחלאל</td>  </tr>\n" +
        "        <tr> <td>כרמי</td>  <td>יכין</td>  <td>יוכבד</td> <td>פרץ</td>  <td>שמרן</td>                 </tr>\n" +
        "    <-->\n" +
        "    </p>\n" +
        "    <p>\n" +
        "      wHi!!!!\n" +
        "    </p>\n" +
        "    <img src=\"https://cdn.glitch.com/38673a51-c444-4193-b256-c5a62fe0bba0%2Funnamed.jpg?1554424587264\">\n" +
        "\n" +
        "    <footer>\n" +
        "      <a href=\"https://www.linkedin.com/in/yair-wasserman-a0a9b2176/\">\n" +
        "        <i class=\"fa fa-linkedin fa-3x\">\n" +
        "      </i>\n" +
        "      </a>\n" +
        "    </footer>\n" +
        "    <!-- include the Glitch button to show what the webpage is about and\n" +
        "          to make it easier for folks to view source and remix -->\n" +
        "    <div class=\"glitchButton\" style=\"position:fixed;top:20px;right:20px;\"></div>\n" +
        "    <script src=\"https://button.glitch.me/button.js\"></script>\n" +
        "  </body>\n" +
        "\n" +
        "</html>\n";
    const cheerio = require('cheerio');
    const $ = cheerio.load(html);
    let a = $.find("table");
    console.log();
    return url;
};

GoobVisitor.prototype.visitExtractStatment = function(ctx) {
    //var value = this.visit(ctx.visitGetURL());
    let url = ctx.word().getText().replace(/\"/g, "");
    //var value = this.visit(ctx.word().getText());
    console.log("Value is : " + url);
    return url;
};

GoobVisitor.prototype.visitUpdateStatment = function(ctx) {
    //var value = this.visit(ctx.visitGetURL());
    let url = ctx.word().getText().replace(/\"/g, "");
    //var value = this.visit(ctx.word().getText());
    console.log("Value is : " + url);
    return url;
};
exports.GoobVisitor = GoobVisitor;
