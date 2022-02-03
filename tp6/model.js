// Implémenter ici les 4 classes du modèle.
// N'oubliez pas l'héritage !

// Classe Drawing
const Drawing = function () {
  this.forms = []

  this.addForm = function (form) {
    this.forms.push(form)
  }

  this.getForms = function () {
    return this.forms
  }
}

// Classe Forme
const Forme = function (x0, y0, x1, y1, lineWidth, color) {
  this.x0 = x0
  this.y0 = y0
  this.x1 = x1
  this.y1 = y1

  this.color = color
  this.lineWidth = lineWidth
}

// Classe Rectangle
const Rectangle = function (x0, y0, x1, y1, lineWidth, color) {
  Forme.call(this, x0, y0, x1, y1, lineWidth, color)
}

// Classe Ligne
const Ligne = function (x0, y0, x1, y1, lineWidth, color) {
  Forme.call(this, x0, y0, x1, y1, lineWidth, color)
}
