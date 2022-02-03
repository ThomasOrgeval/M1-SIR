// La création d'un Dnd requière un canvas et un interacteur.
// L'interacteur viendra dans un second temps donc ne vous en souciez pas au départ.
function DnD(canvas, interactor) {
  // Définir ici les attributs de la 'classe'
  this.x1 = 0
  this.y1 = 0
  this.x2 = 0
  this.y2 = 0

  // Developper les 3 fonctions gérant les événements
  this.drag = function (evt) {
    this.x1 = getMousePosition(canvas, evt)['x']
    this.y1 = getMousePosition(canvas, evt)['y']
    if (interactor !== undefined) interactor.onInteractionStart(this.x1, this.y1, this.x2, this.y2)
  }

  this.dragging = function (evt) {
    this.x2 = getMousePosition(canvas, evt)['x']
    this.y2 = getMousePosition(canvas, evt)['y']
    if (interactor !== undefined) interactor.onInteractionUpdate(this.x1, this.y1, this.x2, this.y2)
  }

  this.drop = function (evt) {
    this.x2 = getMousePosition(canvas, evt)['x']
    this.y2 = getMousePosition(canvas, evt)['y']
    if (interactor !== undefined) interactor.onInteractionEnd(this.x1, this.y1, this.x2, this.y2)
  }

  // Associer les fonctions précédentes aux évènements du canvas.
  canvas.addEventListener("pointerdown", this.drag, {passive: true})
  canvas.addEventListener("pointermove", this.dragging, {passive: true})
  canvas.addEventListener("pointerup", this.drop, {passive: true})
}


// Place le point de l'événement evt relativement à la position du canvas.
function getMousePosition(canvas, evt) {
  const rect = canvas.getBoundingClientRect();
  return {
    x: evt.clientX - rect.left,
    y: evt.clientY - rect.top
  }
}
