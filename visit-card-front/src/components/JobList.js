import {Card, Col, Container, ListGroup, Row} from "react-bootstrap";
import React from "react";

function JobList(props) {

  return (
      <Container>
        <h5>Опыт работы</h5>
        {props.data.map((value) => {
          return (
              <Card>
                <Card.Body>
                  <Card.Title>{value.company}</Card.Title>
                  <Card.Text>
                    <Row>
                      <Col>
                        <h6>Период работы</h6>
                        {value.start} - {value.finish}
                      </Col>
                      <Col>
                        <h6>Должность</h6>
                        {value.position}
                      </Col>
                    </Row>
                    {value.achievements ? (
                        <div>
                          <h6>Достижения</h6>
                          <ListGroup>
                            {value.achievements.map(
                                value1 =>
                                    <ListGroup.Item>{value1}</ListGroup.Item>)
                            }
                          </ListGroup>
                        </div>
                    ) : ''
                    }
                  </Card.Text>
                </Card.Body>
              </Card>)
        })}
      </Container>
  )
}

export default JobList;