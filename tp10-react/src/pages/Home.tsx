import React from 'react'
import {useThemeState} from "../provider/color"
import Wrapper from "../Wrapper";

function Home() {
  const {state} = useThemeState()
  return (
      <Wrapper>
        <div>

        </div>
      </Wrapper>
  )
}

export default Home
