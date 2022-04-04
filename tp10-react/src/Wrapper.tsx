import React from 'react'
import styled from '@emotion/styled'
import Navbar from './components/Navbar'

const Container = styled.section`
  position: relative;
  box-sizing: border-box; 
  width: 100%;
  height: 100vh;
`

const Content = styled.section`
  display: flex;
  width: 100%;
  height: 100vh;
`

const Wrapper = ({children}: any) => {
  return (
      <Container>
        <Navbar/>
        <Content>
          {children}
        </Content>
      </Container>
  )
}

Wrapper.defaultProps = {
  children: null,
}

export default Wrapper
