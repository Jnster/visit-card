import {Card, Col, Container, Row} from "react-bootstrap";
import React from "react";

function EducationList(props) {

  return (
      <Container>
        <h5>Образование</h5>
        {props.data.map((value) => {
          return (
              <Card>
                <Card.Body>
                  <Card.Title>{value.institute}</Card.Title>
                  <Card.Text>
                    <Row>
                      <Col>
                        <h6>Период учёбы</h6>
                        {value.start} - {value.finish}
                      </Col>
                      <Col>
                        <h6>Направление подготовки</h6>
                        {value.direction}
                      </Col>
                    </Row>
                  </Card.Text>
                </Card.Body>
              </Card>)
        })}
      </Container>
  )
}

export default EducationList