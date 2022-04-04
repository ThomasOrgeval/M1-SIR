const lightColors = {
  fontColor: '#040406',
  bgColor: '#FFFFFF',
  inactiveColor: '#FFFFFF',
}

const darkColors = {
  fontColor: '#FFFFFF',
  bgColor: '#040406',
  inactiveColor: '#040406',
}

export const getColor = color => ({theme}) => theme.colors[color];

const margins = {}

const padding = {
  wrapperPadding: '150px',
}

const lightTheme = {
  colors: lightColors,
  margins: margins,
  padding: padding,
}

const darkTheme = {
  colors: darkColors,
  margins: margins,
  padding: padding,
}

export {lightTheme, darkTheme};
