// Generated from ./GoobScraper.g4 by ANTLR 4.7.2
// jshint ignore: start
var antlr4 = require('antlr4/index');

// This class defines a complete generic visitor for a parse tree produced by GoobScraperParser.

function GoobScraperVisitor() {
	antlr4.tree.ParseTreeVisitor.call(this);
	return this;
}

GoobScraperVisitor.prototype = Object.create(antlr4.tree.ParseTreeVisitor.prototype);
GoobScraperVisitor.prototype.constructor = GoobScraperVisitor;

// Visit a parse tree produced by GoobScraperParser#program.
GoobScraperVisitor.prototype.visitProgram = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#GetStatment.
GoobScraperVisitor.prototype.visitGetStatment = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#ExtractStatment.
GoobScraperVisitor.prototype.visitExtractStatment = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#UpdateStatment.
GoobScraperVisitor.prototype.visitUpdateStatment = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#AlertStatment.
GoobScraperVisitor.prototype.visitAlertStatment = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#QuitStatment.
GoobScraperVisitor.prototype.visitQuitStatment = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#RegularGet.
GoobScraperVisitor.prototype.visitRegularGet = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#GetURL.
GoobScraperVisitor.prototype.visitGetURL = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#GetTable.
GoobScraperVisitor.prototype.visitGetTable = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#ExtractAppend.
GoobScraperVisitor.prototype.visitExtractAppend = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#ExtractNew.
GoobScraperVisitor.prototype.visitExtractNew = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#UpdateAppend.
GoobScraperVisitor.prototype.visitUpdateAppend = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#UpdateNew.
GoobScraperVisitor.prototype.visitUpdateNew = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#AlertWord.
GoobScraperVisitor.prototype.visitAlertWord = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#AlertEmpty.
GoobScraperVisitor.prototype.visitAlertEmpty = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#time.
GoobScraperVisitor.prototype.visitTime = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#WordID.
GoobScraperVisitor.prototype.visitWordID = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#WordNumber.
GoobScraperVisitor.prototype.visitWordNumber = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by GoobScraperParser#WordString.
GoobScraperVisitor.prototype.visitWordString = function(ctx) {
  return this.visitChildren(ctx);
};



exports.GoobScraperVisitor = GoobScraperVisitor;