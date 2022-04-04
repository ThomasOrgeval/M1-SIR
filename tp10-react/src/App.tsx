import React, {useEffect} from 'react'
import {darkTheme, lightTheme} from "./library/theme"
import {fontFace} from "./library/fonts"
import {Color as OurColorProvider, useThemeState} from "./provider/color"
import {Global, ThemeProvider as EmotionThemeProvider, css} from "@emotion/react"
import Router from "./Router"
import {createTheme, ThemeProvider} from '@mui/material/styles'

const globalStyles = css`
  *, ::before, ::after {
    margin: 0;
    padding: 0;
  }
  * {
    box-sizing: border-box;
  }
  html {
    font-size: 20px;
  }
  body {
    margin: 0;
    padding: 0;
    transition: background-color 0.2s;
  }
  a {
    text-decoration: none;
    color: inherit;
  }
  button {
    border: none;
  }
`

function App() {
  const {state} = useThemeState()
  const theme = createTheme();
  useEffect(() => {
    state.dark ? document.body.style.background = darkTheme.colors.bgColor
        : document.body.style.background = lightTheme.colors.bgColor
  }, [state.dark])
  return (
      <ThemeProvider theme={theme}>
        <EmotionThemeProvider theme={state.dark ? darkTheme : lightTheme}>
          <Global styles={fontFace}/>
          <Global styles={globalStyles}/>
          <Router/>
        </EmotionThemeProvider>
      </ThemeProvider>
  )
}

const WithContexts = () => (
    <OurColorProvider>
      <App/>
    </OurColorProvider>
)

export default WithContexts
