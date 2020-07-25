import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import TagList from "./components/TagList";
import JobList from "./components/JobList";
import EducationList from "./components/EducationList";
import {Col, Image, Row} from "react-bootstrap";
import axios from "axios";
import config from "./config";

class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      jobs: [],
      interests: [],
      educations: [],
      skills: []
    }
  }

  componentDidMount() {
    axios.get(config.serverUrl + "/api/v1/interests")
    .then(response => this.setState({interests: response.data}))
    .catch(error => console.log(error));

    axios.get(config.serverUrl + "/api/v1/jobs")
    .then(response => this.setState({jobs: response.data}))
    .catch(error => console.log(error));

    axios.get(config.serverUrl + "/api/v1/educations")
    .then(response => this.setState({educations: response.data}))
    .catch(error => console.log(error));

    axios.get(config.serverUrl + "/api/v1/skills")
    .then(response => this.setState({skills: response.data}))
    .catch(error => console.log(error));


  }

  render() {
    console.log(this.state.jobs);
    console.log(this.state.interests);
    console.log(this.state.skills);
    console.log(this.state.educations);
    return (
        <Row>
          <Col xs={1}/>
          <Col fluid>
            <Row>
              <Col xs={3}>
                <Image src={config.photoURL} roundedCircle/>
              </Col>
              <Col fluid className="identity">
                <Row>
                  Климов Антон Олегович
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
            <JobList data={this.state.jobs}/>
            <TagList data={this.state.skills} title={'Навыки'}/>
            <EducationList data={this.state.educations}/>
            <TagList data={this.state.interests} title={'Интересы'}/>
          </Col>
          <Col xs={1}/>
        </Row>
    );
  }
}

export default App;
