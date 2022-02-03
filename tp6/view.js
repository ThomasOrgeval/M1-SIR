// Implémenter ici les fonctions paint à ajouter dans chacune des classes du modèle.
Rectangle.prototype.paint = function (ctx) {
//TODO Manager color
  ctx.fillStyle = this.color
  ctx.rect(this.x0, this.y0, this.x1, this.y1)
  ctx.stroke()
}

Ligne.prototype.paint = function (ctx) {
//TODO Manager color
  ctx.fillStyle = this.color
  ctx.beginPath()
  ctx.moveTo(this.x0, this.y0)
  ctx.lineTo(this.x1, this.y1)
  ctx.stroke()
}

Drawing.prototype.paint = function (ctx) {
  console.log(this.getForms())
  ctx.fillStyle = '#F0F0F0' // set canvas' background color
  ctx.fillRect(0, 0, canvas.width, canvas.height)
  this.getForms().forEach(function (t) {
    // now fill the canvas
    t.paint(ctx)
  })
}
