import React from 'react';
import './App.css';
import TagList from "./components/TagList";
import 'bootstrap/dist/css/bootstrap.min.css';
import JobList from "./components/JobList";
import {Col, Image, Row} from "react-bootstrap";
import EducationList from "./components/EducationList";

function App() {
  const interests = [
    {
      id: 1,
      name: 'Nami'
    },
    {
      id: 2,
      name: 'Kori'
    },
    {
      id: 3,
      name: 'Toto'
    },
    {
      id: 4,
      name: 'Totoro'
    },
    {
      id: 5,
      name: 'Toto'
    },
    {
      id: 6,
      name: 'Toto'
    },
    {
      id: 7,
      name: 'Toto'
    },
    {
      id: 8,
      name: 'Toto'
    },
    {
      id: 9,
      name: 'Toto'
    },
    {
      id: 10,
      name: 'Toto'
    }
  ];

  const jobs = [
    {
      id: 1,
      company: 'OOO pot',
      start: '13-06-2006',
      finish: '04-08-2008',
      position: 'Coolman',
      achievements: [
        'dfgdfg',
        'dgdfg'
      ]
    },
    {
      id: 2,
      company: 'OOO kot',
      start: '13-06-2006',
      finish: '04-08-2008',
      position: 'Coolman'
    }
  ]

  const educations = [
    {
      id: 1,
      institute: 'НГТУ',
      start: '01-09-2016',
      finish: '31-08-2020',
      direction: 'ИВТ'
    }
  ]

  return (
      <Row>
        <Col xs={1}/>
        <Col fluid>
          <Row>
            <Col xs={3}>
              <Image
                  src={'data:image/png;base64,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'}
                  roundedCircle/>
            </Col>
            <Col fluid className="identity">
              <Row>
                Климов Антон Олнгович
              </Row>
              <Row>
                05.06.1998
              </Row>
              <Row>
                Младший разработчик
              </Row>
            </Col>
            <Col xs={2} className="identity">
              <Row>
                тел.: +7 (999) 465-09-51
              </Row>
              <Row>
                e-mail: jnster@yandex.ru
              </Row>
            </Col>
          </Row>
          <JobList data={jobs}/>
          <TagList data={interests} title={'Навыки'}/>
          <EducationList data={educations}/>
          <TagList data={interests} title={'Интересы'}/>
        </Col>
        <Col xs={1}/>
      </Row>
  );
}

export default App;
