import React, {createContext, useContext, useReducer} from "react";

const initial = {
  state: {
    theme: 1,
    dark: false,
    color: '#4FF8B3'
  },
  dispatch: () => null
}

const reducer = (state, {theme, dark}) => {
  switch (theme) {
    case 1:
    default:
      return {
        theme,
        dark,
        color: dark ? '#4FF8B3' : '#09CC92'
      }
    case 2:
      return {
        theme,
        dark,
        color: dark ? '#40AFFF' : '#007DD8'
      }
    case 3:
      return {
        theme,
        dark,
        color: dark ? '#ED7EFF' : '#CD67DD'
      }
    case 4:
      return {
        theme,
        dark,
        color: dark ? '#9570FF' : '#4831D3'
      }
  }
}

export const themeContext = createContext(initial);
export const Color = ({children}) => {
  const [state, dispatch] = useReducer(reducer, initial.state)
  return (
    <themeContext.Provider value={{dispatch, state}}>
      <themeContext.Consumer>
        {(context) => typeof children === 'function'
          ? children(context)
          : React.cloneElement(children, context)}
      </themeContext.Consumer>
    </themeContext.Provider>
  )
}

export const useThemeState = () => {
  return useContext(themeContext)
}
