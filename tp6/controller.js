const editingMode = {rect: 0, line: 1}

function Pencil(ctx, drawing, canvas) {
  this.currEditingMode = editingMode.line
  this.currLineWidth = 5
  this.currColour = document.getElementById('colour').value
  this.currentShape = 0

  // Liez ici les widgets à la classe pour modifier les attributs présents ci-dessus.
  new DnD(canvas, this)

  // Implémentez ici les 3 fonctions onInteractionStart, onInteractionUpdate et onInteractionEnd
  this.onInteractionStart = function (x0, y0, x1, y1) {

  }

  this.onInteractionUpdate = function (x0, y0, x1, y1) {

  }

  this.onInteractionEnd = function (x0, y0, x1, y1) {
    const shape = (this.currentShape === editingMode.line ?
        new Ligne(x0, y0, x1, y1, document.getElementById("spinnerWidth").value, document.getElementById("colour").value) :
        new Rectangle(x0, y0, x1, y1, document.getElementById("spinnerWidth").value, document.getElementById("colour").value)
    )
    drawing.addForm(shape)
    drawing.paint(ctx)
  }
}

