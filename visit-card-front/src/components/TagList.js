import Container from "react-bootstrap/Container";
import Badge from "react-bootstrap/Badge";
import React from 'react';

function TagList(props) {

  let color = ['primary', 'secondary', 'success', 'danger', 'warning', 'info', 'light',
    'dark'];
  let counter = 0;

  return (
      <Container fluid>
        <h5>{props.title}</h5>
        {props.data.map((value) => {
          if (counter >= color.length) counter = 0;
          return (<Badge variant={color[counter++]}>{value.name}</Badge>);
        })
        }
      </Container>
  )
}

export default TagList;