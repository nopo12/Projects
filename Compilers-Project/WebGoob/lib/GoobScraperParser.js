// Generated from ./GoobScraper.g4 by ANTLR 4.7.2
// jshint ignore: start
var antlr4 = require('antlr4/index');
var GoobScraperListener = require('./GoobScraperListener').GoobScraperListener;
var GoobScraperVisitor = require('./GoobScraperVisitor').GoobScraperVisitor;

var grammarFileName = "GoobScraper.g4";


var serializedATN = ["\u0003\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964",
    "\u0003\u0015U\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004\u0004\t",
    "\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t\u0007\u0004",
    "\b\t\b\u0004\t\t\t\u0003\u0002\u0006\u0002\u0014\n\u0002\r\u0002\u000e",
    "\u0002\u0015\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003",
    "\u0003\u0003\u0003\u0003\u0005\u0003\u001f\n\u0003\u0003\u0003\u0003",
    "\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0005\u0003\'",
    "\n\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003",
    "\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0005\u0003",
    "3\n\u0003\u0003\u0004\u0003\u0004\u0005\u00047\n\u0004\u0003\u0004\u0003",
    "\u0004\u0003\u0004\u0003\u0004\u0005\u0004=\n\u0004\u0005\u0004?\n\u0004",
    "\u0003\u0005\u0003\u0005\u0005\u0005C\n\u0005\u0003\u0006\u0003\u0006",
    "\u0005\u0006G\n\u0006\u0003\u0007\u0003\u0007\u0005\u0007K\n\u0007\u0003",
    "\b\u0003\b\u0003\b\u0003\t\u0003\t\u0003\t\u0005\tS\n\t\u0003\t\u0002",
    "\u0002\n\u0002\u0004\u0006\b\n\f\u000e\u0010\u0002\u0004\u0003\u0002",
    "\n\u000b\u0003\u0002\u000e\u0011\u0002\\\u0002\u0013\u0003\u0002\u0002",
    "\u0002\u00042\u0003\u0002\u0002\u0002\u0006>\u0003\u0002\u0002\u0002",
    "\bB\u0003\u0002\u0002\u0002\nF\u0003\u0002\u0002\u0002\fJ\u0003\u0002",
    "\u0002\u0002\u000eL\u0003\u0002\u0002\u0002\u0010R\u0003\u0002\u0002",
    "\u0002\u0012\u0014\u0005\u0004\u0003\u0002\u0013\u0012\u0003\u0002\u0002",
    "\u0002\u0014\u0015\u0003\u0002\u0002\u0002\u0015\u0013\u0003\u0002\u0002",
    "\u0002\u0015\u0016\u0003\u0002\u0002\u0002\u0016\u0003\u0003\u0002\u0002",
    "\u0002\u0017\u0018\u0007\u0003\u0002\u0002\u0018\u0019\u0005\u0006\u0004",
    "\u0002\u0019\u001a\u0007\u0004\u0002\u0002\u001a3\u0003\u0002\u0002",
    "\u0002\u001b\u001c\u0007\u0005\u0002\u0002\u001c\u001e\u0005\b\u0005",
    "\u0002\u001d\u001f\u0005\u0010\t\u0002\u001e\u001d\u0003\u0002\u0002",
    "\u0002\u001e\u001f\u0003\u0002\u0002\u0002\u001f \u0003\u0002\u0002",
    "\u0002 !\u0005\u0010\t\u0002!\"\u0007\u0004\u0002\u0002\"3\u0003\u0002",
    "\u0002\u0002#$\u0007\u0006\u0002\u0002$&\u0005\n\u0006\u0002%\'\u0005",
    "\u0010\t\u0002&%\u0003\u0002\u0002\u0002&\'\u0003\u0002\u0002\u0002",
    "\'(\u0003\u0002\u0002\u0002()\u0005\u000e\b\u0002)*\u0007\u0004\u0002",
    "\u0002*3\u0003\u0002\u0002\u0002+,\u0007\u0007\u0002\u0002,-\u0005\f",
    "\u0007\u0002-.\u0005\u000e\b\u0002./\u0007\u0004\u0002\u0002/3\u0003",
    "\u0002\u0002\u000201\u0007\b\u0002\u000213\u0007\u0004\u0002\u00022",
    "\u0017\u0003\u0002\u0002\u00022\u001b\u0003\u0002\u0002\u00022#\u0003",
    "\u0002\u0002\u00022+\u0003\u0002\u0002\u000220\u0003\u0002\u0002\u0002",
    "3\u0005\u0003\u0002\u0002\u000246\u0005\u0010\t\u000257\u0005\u0010",
    "\t\u000265\u0003\u0002\u0002\u000267\u0003\u0002\u0002\u00027?\u0003",
    "\u0002\u0002\u000289\u0007\t\u0002\u00029?\u0005\u0010\t\u0002:<\t\u0002",
    "\u0002\u0002;=\u0005\u0010\t\u0002<;\u0003\u0002\u0002\u0002<=\u0003",
    "\u0002\u0002\u0002=?\u0003\u0002\u0002\u0002>4\u0003\u0002\u0002\u0002",
    ">8\u0003\u0002\u0002\u0002>:\u0003\u0002\u0002\u0002?\u0007\u0003\u0002",
    "\u0002\u0002@C\u0007\f\u0002\u0002AC\u0007\r\u0002\u0002B@\u0003\u0002",
    "\u0002\u0002BA\u0003\u0002\u0002\u0002C\t\u0003\u0002\u0002\u0002DG",
    "\u0007\f\u0002\u0002EG\u0007\r\u0002\u0002FD\u0003\u0002\u0002\u0002",
    "FE\u0003\u0002\u0002\u0002G\u000b\u0003\u0002\u0002\u0002HK\u0005\u0010",
    "\t\u0002IK\u0003\u0002\u0002\u0002JH\u0003\u0002\u0002\u0002JI\u0003",
    "\u0002\u0002\u0002K\r\u0003\u0002\u0002\u0002LM\u0007\u0014\u0002\u0002",
    "MN\t\u0003\u0002\u0002N\u000f\u0003\u0002\u0002\u0002OS\u0007\u0013",
    "\u0002\u0002PS\u0007\u0014\u0002\u0002QS\u0007\u0012\u0002\u0002RO\u0003",
    "\u0002\u0002\u0002RP\u0003\u0002\u0002\u0002RQ\u0003\u0002\u0002\u0002",
    "S\u0011\u0003\u0002\u0002\u0002\r\u0015\u001e&26<>BFJR"].join("");


var atn = new antlr4.atn.ATNDeserializer().deserialize(serializedATN);

var decisionsToDFA = atn.decisionToState.map( function(ds, index) { return new antlr4.dfa.DFA(ds, index); });

var sharedContextCache = new antlr4.PredictionContextCache();

var literalNames = [ null, "'/get'", "';'", "'/extract'", "'/update'", "'/alert'", 
                     "'/quit'", "'url'", "'tables'", "'table'", "'append'", 
                     "'new'", "'sec'", "'min'", "'hrs'", "'day'" ];

var symbolicNames = [ null, null, null, null, null, null, null, null, null, 
                      null, null, null, null, null, null, null, "STRING", 
                      "ID", "NUMBER", "WS" ];

var ruleNames =  [ "program", "statment", "get", "extract", "update", "alert", 
                   "time", "word" ];

function GoobScraperParser (input) {
	antlr4.Parser.call(this, input);
    this._interp = new antlr4.atn.ParserATNSimulator(this, atn, decisionsToDFA, sharedContextCache);
    this.ruleNames = ruleNames;
    this.literalNames = literalNames;
    this.symbolicNames = symbolicNames;
    return this;
}

GoobScraperParser.prototype = Object.create(antlr4.Parser.prototype);
GoobScraperParser.prototype.constructor = GoobScraperParser;

Object.defineProperty(GoobScraperParser.prototype, "atn", {
	get : function() {
		return atn;
	}
});

GoobScraperParser.EOF = antlr4.Token.EOF;
GoobScraperParser.T__0 = 1;
GoobScraperParser.T__1 = 2;
GoobScraperParser.T__2 = 3;
GoobScraperParser.T__3 = 4;
GoobScraperParser.T__4 = 5;
GoobScraperParser.T__5 = 6;
GoobScraperParser.T__6 = 7;
GoobScraperParser.T__7 = 8;
GoobScraperParser.T__8 = 9;
GoobScraperParser.T__9 = 10;
GoobScraperParser.T__10 = 11;
GoobScraperParser.T__11 = 12;
GoobScraperParser.T__12 = 13;
GoobScraperParser.T__13 = 14;
GoobScraperParser.T__14 = 15;
GoobScraperParser.STRING = 16;
GoobScraperParser.ID = 17;
GoobScraperParser.NUMBER = 18;
GoobScraperParser.WS = 19;

GoobScraperParser.RULE_program = 0;
GoobScraperParser.RULE_statment = 1;
GoobScraperParser.RULE_get = 2;
GoobScraperParser.RULE_extract = 3;
GoobScraperParser.RULE_update = 4;
GoobScraperParser.RULE_alert = 5;
GoobScraperParser.RULE_time = 6;
GoobScraperParser.RULE_word = 7;


function ProgramContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = GoobScraperParser.RULE_program;
    return this;
}

ProgramContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ProgramContext.prototype.constructor = ProgramContext;

ProgramContext.prototype.statment = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(StatmentContext);
    } else {
        return this.getTypedRuleContext(StatmentContext,i);
    }
};

ProgramContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterProgram(this);
	}
};

ProgramContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitProgram(this);
	}
};

ProgramContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitProgram(this);
    } else {
        return visitor.visitChildren(this);
    }
};




GoobScraperParser.ProgramContext = ProgramContext;

GoobScraperParser.prototype.program = function() {

    var localctx = new ProgramContext(this, this._ctx, this.state);
    this.enterRule(localctx, 0, GoobScraperParser.RULE_program);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 17; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 16;
            this.statment();
            this.state = 19; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while((((_la) & ~0x1f) == 0 && ((1 << _la) & ((1 << GoobScraperParser.T__0) | (1 << GoobScraperParser.T__2) | (1 << GoobScraperParser.T__3) | (1 << GoobScraperParser.T__4) | (1 << GoobScraperParser.T__5))) !== 0));
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function StatmentContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = GoobScraperParser.RULE_statment;
    return this;
}

StatmentContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
StatmentContext.prototype.constructor = StatmentContext;


 
StatmentContext.prototype.copyFrom = function(ctx) {
    antlr4.ParserRuleContext.prototype.copyFrom.call(this, ctx);
};


function GetStatmentContext(parser, ctx) {
	StatmentContext.call(this, parser);
    StatmentContext.prototype.copyFrom.call(this, ctx);
    return this;
}

GetStatmentContext.prototype = Object.create(StatmentContext.prototype);
GetStatmentContext.prototype.constructor = GetStatmentContext;

GoobScraperParser.GetStatmentContext = GetStatmentContext;

GetStatmentContext.prototype.get = function() {
    return this.getTypedRuleContext(GetContext,0);
};
GetStatmentContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterGetStatment(this);
	}
};

GetStatmentContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitGetStatment(this);
	}
};

GetStatmentContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitGetStatment(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function UpdateStatmentContext(parser, ctx) {
	StatmentContext.call(this, parser);
    StatmentContext.prototype.copyFrom.call(this, ctx);
    return this;
}

UpdateStatmentContext.prototype = Object.create(StatmentContext.prototype);
UpdateStatmentContext.prototype.constructor = UpdateStatmentContext;

GoobScraperParser.UpdateStatmentContext = UpdateStatmentContext;

UpdateStatmentContext.prototype.update = function() {
    return this.getTypedRuleContext(UpdateContext,0);
};

UpdateStatmentContext.prototype.time = function() {
    return this.getTypedRuleContext(TimeContext,0);
};

UpdateStatmentContext.prototype.word = function() {
    return this.getTypedRuleContext(WordContext,0);
};
UpdateStatmentContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterUpdateStatment(this);
	}
};

UpdateStatmentContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitUpdateStatment(this);
	}
};

UpdateStatmentContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitUpdateStatment(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function ExtractStatmentContext(parser, ctx) {
	StatmentContext.call(this, parser);
    StatmentContext.prototype.copyFrom.call(this, ctx);
    return this;
}

ExtractStatmentContext.prototype = Object.create(StatmentContext.prototype);
ExtractStatmentContext.prototype.constructor = ExtractStatmentContext;

GoobScraperParser.ExtractStatmentContext = ExtractStatmentContext;

ExtractStatmentContext.prototype.extract = function() {
    return this.getTypedRuleContext(ExtractContext,0);
};

ExtractStatmentContext.prototype.word = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(WordContext);
    } else {
        return this.getTypedRuleContext(WordContext,i);
    }
};
ExtractStatmentContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterExtractStatment(this);
	}
};

ExtractStatmentContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitExtractStatment(this);
	}
};

ExtractStatmentContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitExtractStatment(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function AlertStatmentContext(parser, ctx) {
	StatmentContext.call(this, parser);
    StatmentContext.prototype.copyFrom.call(this, ctx);
    return this;
}

AlertStatmentContext.prototype = Object.create(StatmentContext.prototype);
AlertStatmentContext.prototype.constructor = AlertStatmentContext;

GoobScraperParser.AlertStatmentContext = AlertStatmentContext;

AlertStatmentContext.prototype.alert = function() {
    return this.getTypedRuleContext(AlertContext,0);
};

AlertStatmentContext.prototype.time = function() {
    return this.getTypedRuleContext(TimeContext,0);
};
AlertStatmentContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterAlertStatment(this);
	}
};

AlertStatmentContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitAlertStatment(this);
	}
};

AlertStatmentContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitAlertStatment(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function QuitStatmentContext(parser, ctx) {
	StatmentContext.call(this, parser);
    StatmentContext.prototype.copyFrom.call(this, ctx);
    return this;
}

QuitStatmentContext.prototype = Object.create(StatmentContext.prototype);
QuitStatmentContext.prototype.constructor = QuitStatmentContext;

GoobScraperParser.QuitStatmentContext = QuitStatmentContext;

QuitStatmentContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterQuitStatment(this);
	}
};

QuitStatmentContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitQuitStatment(this);
	}
};

QuitStatmentContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitQuitStatment(this);
    } else {
        return visitor.visitChildren(this);
    }
};



GoobScraperParser.StatmentContext = StatmentContext;

GoobScraperParser.prototype.statment = function() {

    var localctx = new StatmentContext(this, this._ctx, this.state);
    this.enterRule(localctx, 2, GoobScraperParser.RULE_statment);
    try {
        this.state = 48;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case GoobScraperParser.T__0:
            localctx = new GetStatmentContext(this, localctx);
            this.enterOuterAlt(localctx, 1);
            this.state = 21;
            this.match(GoobScraperParser.T__0);
            this.state = 22;
            this.get();
            this.state = 23;
            this.match(GoobScraperParser.T__1);
            break;
        case GoobScraperParser.T__2:
            localctx = new ExtractStatmentContext(this, localctx);
            this.enterOuterAlt(localctx, 2);
            this.state = 25;
            this.match(GoobScraperParser.T__2);
            this.state = 26;
            this.extract();
            this.state = 28;
            this._errHandler.sync(this);
            var la_ = this._interp.adaptivePredict(this._input,1,this._ctx);
            if(la_===1) {
                this.state = 27;
                this.word();

            }

            this.state = 30;
            this.word();
            this.state = 31;
            this.match(GoobScraperParser.T__1);
            break;
        case GoobScraperParser.T__3:
            localctx = new UpdateStatmentContext(this, localctx);
            this.enterOuterAlt(localctx, 3);
            this.state = 33;
            this.match(GoobScraperParser.T__3);
            this.state = 34;
            this.update();
            this.state = 36;
            this._errHandler.sync(this);
            var la_ = this._interp.adaptivePredict(this._input,2,this._ctx);
            if(la_===1) {
                this.state = 35;
                this.word();

            }
            this.state = 38;
            this.time();
            this.state = 39;
            this.match(GoobScraperParser.T__1);
            break;
        case GoobScraperParser.T__4:
            localctx = new AlertStatmentContext(this, localctx);
            this.enterOuterAlt(localctx, 4);
            this.state = 41;
            this.match(GoobScraperParser.T__4);
            this.state = 42;
            this.alert();
            this.state = 43;
            this.time();
            this.state = 44;
            this.match(GoobScraperParser.T__1);
            break;
        case GoobScraperParser.T__5:
            localctx = new QuitStatmentContext(this, localctx);
            this.enterOuterAlt(localctx, 5);
            this.state = 46;
            this.match(GoobScraperParser.T__5);
            this.state = 47;
            this.match(GoobScraperParser.T__1);
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function GetContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = GoobScraperParser.RULE_get;
    return this;
}

GetContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
GetContext.prototype.constructor = GetContext;


 
GetContext.prototype.copyFrom = function(ctx) {
    antlr4.ParserRuleContext.prototype.copyFrom.call(this, ctx);
};


function GetTableContext(parser, ctx) {
	GetContext.call(this, parser);
    GetContext.prototype.copyFrom.call(this, ctx);
    return this;
}

GetTableContext.prototype = Object.create(GetContext.prototype);
GetTableContext.prototype.constructor = GetTableContext;

GoobScraperParser.GetTableContext = GetTableContext;

GetTableContext.prototype.word = function() {
    return this.getTypedRuleContext(WordContext,0);
};
GetTableContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterGetTable(this);
	}
};

GetTableContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitGetTable(this);
	}
};

GetTableContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitGetTable(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function GetURLContext(parser, ctx) {
	GetContext.call(this, parser);
    GetContext.prototype.copyFrom.call(this, ctx);
    return this;
}

GetURLContext.prototype = Object.create(GetContext.prototype);
GetURLContext.prototype.constructor = GetURLContext;

GoobScraperParser.GetURLContext = GetURLContext;

GetURLContext.prototype.word = function() {
    return this.getTypedRuleContext(WordContext,0);
};
GetURLContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterGetURL(this);
	}
};

GetURLContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitGetURL(this);
	}
};

GetURLContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitGetURL(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function RegularGetContext(parser, ctx) {
	GetContext.call(this, parser);
    GetContext.prototype.copyFrom.call(this, ctx);
    return this;
}

RegularGetContext.prototype = Object.create(GetContext.prototype);
RegularGetContext.prototype.constructor = RegularGetContext;

GoobScraperParser.RegularGetContext = RegularGetContext;

RegularGetContext.prototype.word = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(WordContext);
    } else {
        return this.getTypedRuleContext(WordContext,i);
    }
};
RegularGetContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterRegularGet(this);
	}
};

RegularGetContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitRegularGet(this);
	}
};

RegularGetContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitRegularGet(this);
    } else {
        return visitor.visitChildren(this);
    }
};



GoobScraperParser.GetContext = GetContext;

GoobScraperParser.prototype.get = function() {

    var localctx = new GetContext(this, this._ctx, this.state);
    this.enterRule(localctx, 4, GoobScraperParser.RULE_get);
    var _la = 0; // Token type
    try {
        this.state = 60;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case GoobScraperParser.STRING:
        case GoobScraperParser.ID:
        case GoobScraperParser.NUMBER:
            localctx = new RegularGetContext(this, localctx);
            this.enterOuterAlt(localctx, 1);
            this.state = 50;
            this.word();
            this.state = 52;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if((((_la) & ~0x1f) == 0 && ((1 << _la) & ((1 << GoobScraperParser.STRING) | (1 << GoobScraperParser.ID) | (1 << GoobScraperParser.NUMBER))) !== 0)) {
                this.state = 51;
                this.word();
            }

            break;
        case GoobScraperParser.T__6:
            localctx = new GetURLContext(this, localctx);
            this.enterOuterAlt(localctx, 2);
            this.state = 54;
            this.match(GoobScraperParser.T__6);

            this.state = 55;
            this.word();
            break;
        case GoobScraperParser.T__7:
        case GoobScraperParser.T__8:
            localctx = new GetTableContext(this, localctx);
            this.enterOuterAlt(localctx, 3);
            this.state = 56;
            _la = this._input.LA(1);
            if(!(_la===GoobScraperParser.T__7 || _la===GoobScraperParser.T__8)) {
            this._errHandler.recoverInline(this);
            }
            else {
            	this._errHandler.reportMatch(this);
                this.consume();
            }
            this.state = 58;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if((((_la) & ~0x1f) == 0 && ((1 << _la) & ((1 << GoobScraperParser.STRING) | (1 << GoobScraperParser.ID) | (1 << GoobScraperParser.NUMBER))) !== 0)) {
                this.state = 57;
                this.word();
            }

            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function ExtractContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = GoobScraperParser.RULE_extract;
    return this;
}

ExtractContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ExtractContext.prototype.constructor = ExtractContext;


 
ExtractContext.prototype.copyFrom = function(ctx) {
    antlr4.ParserRuleContext.prototype.copyFrom.call(this, ctx);
};


function ExtractAppendContext(parser, ctx) {
	ExtractContext.call(this, parser);
    ExtractContext.prototype.copyFrom.call(this, ctx);
    return this;
}

ExtractAppendContext.prototype = Object.create(ExtractContext.prototype);
ExtractAppendContext.prototype.constructor = ExtractAppendContext;

GoobScraperParser.ExtractAppendContext = ExtractAppendContext;

ExtractAppendContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterExtractAppend(this);
	}
};

ExtractAppendContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitExtractAppend(this);
	}
};

ExtractAppendContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitExtractAppend(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function ExtractNewContext(parser, ctx) {
	ExtractContext.call(this, parser);
    ExtractContext.prototype.copyFrom.call(this, ctx);
    return this;
}

ExtractNewContext.prototype = Object.create(ExtractContext.prototype);
ExtractNewContext.prototype.constructor = ExtractNewContext;

GoobScraperParser.ExtractNewContext = ExtractNewContext;

ExtractNewContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterExtractNew(this);
	}
};

ExtractNewContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitExtractNew(this);
	}
};

ExtractNewContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitExtractNew(this);
    } else {
        return visitor.visitChildren(this);
    }
};



GoobScraperParser.ExtractContext = ExtractContext;

GoobScraperParser.prototype.extract = function() {

    var localctx = new ExtractContext(this, this._ctx, this.state);
    this.enterRule(localctx, 6, GoobScraperParser.RULE_extract);
    try {
        this.state = 64;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case GoobScraperParser.T__9:
            localctx = new ExtractAppendContext(this, localctx);
            this.enterOuterAlt(localctx, 1);
            this.state = 62;
            this.match(GoobScraperParser.T__9);
            break;
        case GoobScraperParser.T__10:
            localctx = new ExtractNewContext(this, localctx);
            this.enterOuterAlt(localctx, 2);
            this.state = 63;
            this.match(GoobScraperParser.T__10);
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function UpdateContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = GoobScraperParser.RULE_update;
    return this;
}

UpdateContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
UpdateContext.prototype.constructor = UpdateContext;


 
UpdateContext.prototype.copyFrom = function(ctx) {
    antlr4.ParserRuleContext.prototype.copyFrom.call(this, ctx);
};


function UpdateNewContext(parser, ctx) {
	UpdateContext.call(this, parser);
    UpdateContext.prototype.copyFrom.call(this, ctx);
    return this;
}

UpdateNewContext.prototype = Object.create(UpdateContext.prototype);
UpdateNewContext.prototype.constructor = UpdateNewContext;

GoobScraperParser.UpdateNewContext = UpdateNewContext;

UpdateNewContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterUpdateNew(this);
	}
};

UpdateNewContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitUpdateNew(this);
	}
};

UpdateNewContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitUpdateNew(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function UpdateAppendContext(parser, ctx) {
	UpdateContext.call(this, parser);
    UpdateContext.prototype.copyFrom.call(this, ctx);
    return this;
}

UpdateAppendContext.prototype = Object.create(UpdateContext.prototype);
UpdateAppendContext.prototype.constructor = UpdateAppendContext;

GoobScraperParser.UpdateAppendContext = UpdateAppendContext;

UpdateAppendContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterUpdateAppend(this);
	}
};

UpdateAppendContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitUpdateAppend(this);
	}
};

UpdateAppendContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitUpdateAppend(this);
    } else {
        return visitor.visitChildren(this);
    }
};



GoobScraperParser.UpdateContext = UpdateContext;

GoobScraperParser.prototype.update = function() {

    var localctx = new UpdateContext(this, this._ctx, this.state);
    this.enterRule(localctx, 8, GoobScraperParser.RULE_update);
    try {
        this.state = 68;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case GoobScraperParser.T__9:
            localctx = new UpdateAppendContext(this, localctx);
            this.enterOuterAlt(localctx, 1);
            this.state = 66;
            this.match(GoobScraperParser.T__9);
            break;
        case GoobScraperParser.T__10:
            localctx = new UpdateNewContext(this, localctx);
            this.enterOuterAlt(localctx, 2);
            this.state = 67;
            this.match(GoobScraperParser.T__10);
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function AlertContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = GoobScraperParser.RULE_alert;
    return this;
}

AlertContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
AlertContext.prototype.constructor = AlertContext;


 
AlertContext.prototype.copyFrom = function(ctx) {
    antlr4.ParserRuleContext.prototype.copyFrom.call(this, ctx);
};


function AlertEmptyContext(parser, ctx) {
	AlertContext.call(this, parser);
    AlertContext.prototype.copyFrom.call(this, ctx);
    return this;
}

AlertEmptyContext.prototype = Object.create(AlertContext.prototype);
AlertEmptyContext.prototype.constructor = AlertEmptyContext;

GoobScraperParser.AlertEmptyContext = AlertEmptyContext;

AlertEmptyContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterAlertEmpty(this);
	}
};

AlertEmptyContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitAlertEmpty(this);
	}
};

AlertEmptyContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitAlertEmpty(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function AlertWordContext(parser, ctx) {
	AlertContext.call(this, parser);
    AlertContext.prototype.copyFrom.call(this, ctx);
    return this;
}

AlertWordContext.prototype = Object.create(AlertContext.prototype);
AlertWordContext.prototype.constructor = AlertWordContext;

GoobScraperParser.AlertWordContext = AlertWordContext;

AlertWordContext.prototype.word = function() {
    return this.getTypedRuleContext(WordContext,0);
};
AlertWordContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterAlertWord(this);
	}
};

AlertWordContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitAlertWord(this);
	}
};

AlertWordContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitAlertWord(this);
    } else {
        return visitor.visitChildren(this);
    }
};



GoobScraperParser.AlertContext = AlertContext;

GoobScraperParser.prototype.alert = function() {

    var localctx = new AlertContext(this, this._ctx, this.state);
    this.enterRule(localctx, 10, GoobScraperParser.RULE_alert);
    try {
        this.state = 72;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,9,this._ctx);
        switch(la_) {
        case 1:
            localctx = new AlertWordContext(this, localctx);
            this.enterOuterAlt(localctx, 1);
            this.state = 70;
            this.word();
            break;

        case 2:
            localctx = new AlertEmptyContext(this, localctx);
            this.enterOuterAlt(localctx, 2);

            break;

        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function TimeContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = GoobScraperParser.RULE_time;
    return this;
}

TimeContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
TimeContext.prototype.constructor = TimeContext;

TimeContext.prototype.NUMBER = function() {
    return this.getToken(GoobScraperParser.NUMBER, 0);
};

TimeContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterTime(this);
	}
};

TimeContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitTime(this);
	}
};

TimeContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitTime(this);
    } else {
        return visitor.visitChildren(this);
    }
};




GoobScraperParser.TimeContext = TimeContext;

GoobScraperParser.prototype.time = function() {

    var localctx = new TimeContext(this, this._ctx, this.state);
    this.enterRule(localctx, 12, GoobScraperParser.RULE_time);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 74;
        this.match(GoobScraperParser.NUMBER);
        this.state = 75;
        _la = this._input.LA(1);
        if(!((((_la) & ~0x1f) == 0 && ((1 << _la) & ((1 << GoobScraperParser.T__11) | (1 << GoobScraperParser.T__12) | (1 << GoobScraperParser.T__13) | (1 << GoobScraperParser.T__14))) !== 0))) {
        this._errHandler.recoverInline(this);
        }
        else {
        	this._errHandler.reportMatch(this);
            this.consume();
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function WordContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = GoobScraperParser.RULE_word;
    return this;
}

WordContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
WordContext.prototype.constructor = WordContext;


 
WordContext.prototype.copyFrom = function(ctx) {
    antlr4.ParserRuleContext.prototype.copyFrom.call(this, ctx);
};


function WordIDContext(parser, ctx) {
	WordContext.call(this, parser);
    WordContext.prototype.copyFrom.call(this, ctx);
    return this;
}

WordIDContext.prototype = Object.create(WordContext.prototype);
WordIDContext.prototype.constructor = WordIDContext;

GoobScraperParser.WordIDContext = WordIDContext;

WordIDContext.prototype.ID = function() {
    return this.getToken(GoobScraperParser.ID, 0);
};
WordIDContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterWordID(this);
	}
};

WordIDContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitWordID(this);
	}
};

WordIDContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitWordID(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function WordNumberContext(parser, ctx) {
	WordContext.call(this, parser);
    WordContext.prototype.copyFrom.call(this, ctx);
    return this;
}

WordNumberContext.prototype = Object.create(WordContext.prototype);
WordNumberContext.prototype.constructor = WordNumberContext;

GoobScraperParser.WordNumberContext = WordNumberContext;

WordNumberContext.prototype.NUMBER = function() {
    return this.getToken(GoobScraperParser.NUMBER, 0);
};
WordNumberContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterWordNumber(this);
	}
};

WordNumberContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitWordNumber(this);
	}
};

WordNumberContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitWordNumber(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function WordStringContext(parser, ctx) {
	WordContext.call(this, parser);
    WordContext.prototype.copyFrom.call(this, ctx);
    return this;
}

WordStringContext.prototype = Object.create(WordContext.prototype);
WordStringContext.prototype.constructor = WordStringContext;

GoobScraperParser.WordStringContext = WordStringContext;

WordStringContext.prototype.STRING = function() {
    return this.getToken(GoobScraperParser.STRING, 0);
};
WordStringContext.prototype.enterRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.enterWordString(this);
	}
};

WordStringContext.prototype.exitRule = function(listener) {
    if(listener instanceof GoobScraperListener ) {
        listener.exitWordString(this);
	}
};

WordStringContext.prototype.accept = function(visitor) {
    if ( visitor instanceof GoobScraperVisitor ) {
        return visitor.visitWordString(this);
    } else {
        return visitor.visitChildren(this);
    }
};



GoobScraperParser.WordContext = WordContext;

GoobScraperParser.prototype.word = function() {

    var localctx = new WordContext(this, this._ctx, this.state);
    this.enterRule(localctx, 14, GoobScraperParser.RULE_word);
    try {
        this.state = 80;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case GoobScraperParser.ID:
            localctx = new WordIDContext(this, localctx);
            this.enterOuterAlt(localctx, 1);
            this.state = 77;
            this.match(GoobScraperParser.ID);
            break;
        case GoobScraperParser.NUMBER:
            localctx = new WordNumberContext(this, localctx);
            this.enterOuterAlt(localctx, 2);
            this.state = 78;
            this.match(GoobScraperParser.NUMBER);
            break;
        case GoobScraperParser.STRING:
            localctx = new WordStringContext(this, localctx);
            this.enterOuterAlt(localctx, 3);
            this.state = 79;
            this.match(GoobScraperParser.STRING);
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


exports.GoobScraperParser = GoobScraperParser;
