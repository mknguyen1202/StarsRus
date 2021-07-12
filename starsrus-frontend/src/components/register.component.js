import React, { Component } from "react";
import { Redirect } from 'react-router-dom';
// import Form from "react-validation/build/form";
// import Input from "react-validation/build/input";
// import CheckButton from "react-validation/build/button";
import { isEmail } from "validator";

import { Card, Form as Form, Button, Container, Row, Col, Modal} from "react-bootstrap";
import { connect } from "react-redux";
import { register } from "../actions/auth";

import { ValidatorForm, TextValidator } from 'react-material-ui-form-validator';
import "../style/MainStyleSheet.css";

const required = (value) => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};

const email = (value) => {
  if (!isEmail(value)) {
    return (
      <div className="alert alert-danger" role="alert">
        This is not a valid email.
      </div>
    );
  }
};

const vusername = (value) => {
  if (value.length < 3 || value.length > 30) {
    return (
      <div className="alert alert-danger" role="alert">
        The username must be between 3 and 30 characters.
      </div>
    );
  }
};

const vpassword = (value) => {
  if (value.length < 6 || value.length > 30) {
    return (
      <div className="alert alert-danger" role="alert">
        The password must be between 6 and 30 characters.
      </div>
    );
  }
};

const initialState = {
  username: "",
  password: "",
  repeatpassword: "",
  firstname: "",
  lastname: "",
  dob: "",
  address1: "",
  address2: "",
  state: "",
  phone: "",
  email: "",
  ssn: "",
  terms: false,

  usernameError: "",
  passwordError: "",
  repeatpasswordError: "",
  nameError: "",
  dobError: "",
  address1Error: "",
  stateError: "",
  emailError: "",

  modalshow: false,

  successful: false,
};

class Register extends Component {
  constructor(props) {
    super(props);
    this.handleRegister = this.handleRegister.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.handleClose = this.handleClose.bind(this);
    this.handleShow = this.handleShow.bind(this);


    this.state =
    {
      username: "",
      password: "",
      repeatpassword: "",
      firstname: "",
      lastname: "",
      dob: "",
      address1: "",
      address2: "",
      state: "",
      phone: "",
      email: "",
      ssn: "",
      terms: false,

      usernameError: "",
      passwordError: "",
      repeatpasswordError: "",
      nameError: "",
      dobError: "",
      address1Error: "",
      stateError: "",
      emailError: "",

      successful: false,
    };
  }

  isValidInputs = () => {

    let usernameErrors = "";
    let passwordError = "";
    let repeatpasswordError = "";
    let nameError = "";
    let dobError = "";
    let address1Error = "";
    let stateError = "";
    let phoneError = "";
    let emailError = "";

    if (!this.state.username || this.state.username.length < 3) {
      usernameErrors = "Username must be at least 3 characters";
      console.log("EMMPTY USERNAME", usernameErrors);
    }

    if (!this.state.password || this.state.password.length < 6) {
      passwordError = "Password must be at least 6 characters";
    }

    if (this.state.password !== this.state.repeatpassword) {
      repeatpasswordError = "Passwords are not the same";
    }

    if (!this.state.firstname || !this.state.lastname) {
      nameError = "Firstname and Lastname cannot be blank";
    }

    if (!this.state.dob) {
      dobError = "Please input your date of birth";
    }

    if (!this.state.address1) {
      // address1Error = "Please input an address";
    }

    if (!this.state.state) {
      stateError = "Please choose a state";
    }

    
    
    if (!this.state.email) {
      emailError = "Email is required";
    } else if (!isEmail(this.state.email)) {
      emailError = "Invalid email";
    }

    if (usernameErrors || passwordError || repeatpasswordError || nameError || dobError || stateError || emailError) {
      this.setState({
        usernameError: usernameErrors,
        passwordError: passwordError,
        repeatpasswordError: repeatpasswordError,
        nameError: nameError,
        dobError: dobError,
        address1Error: address1Error,
        stateError: stateError,
        emailError: emailError
      }, () => {
        console.log("SET USERNAME", usernameErrors, this.state.usernameError);
        console.log(this.state);
      });

      return false;
    }

    return true;

  }

  // componentDidUpdate();

  // componentDidMount() {
  //   // custom rule will have name 'isPasswordMatch'
  //   ValidatorForm.addValidationRule('isPasswordMatch', (value) => {
  //       if (value !== this.state.user.password) {
  //           return false;
  //       }
  //       return true;
  //   });
  // }

  // componentWillUnmount() {
  //     // remove rule when it is not needed
  //     ValidatorForm.removeValidationRule('isPasswordMatch');
  // }

  handleShow = () => {
    this.setState({
      modalshow: true
    });
    console.log("WTF", this.state.modalshow);
  }

  handleClose = () => {
    this.setState({
      modalshow: false
    });
    this.props.history.push('/login');
  }


  handleChange = (e) => {
    console.log(e.target.name);
    console.log(e.target.value);
    this.setState({
      [e.target.name]: e.target.value
    });

    if (this.state.password !== this.state.repeatpassword) {

    }
  }

  handleRegister(e) {
    e.preventDefault();

    this.setState({
      successful: false,
    });

    if (this.isValidInputs()) {
      this.props
        .dispatch(
          register(
            this.state.username,
            this.state.password,
            this.state.firstname,
            this.state.lastname,
            this.state.dob,
            this.state.address1 + ", " + this.state.address2,
            this.state.state,
            this.state.phone,
            this.state.email,
            this.state.ssn,
            ["user"])
        )
        .then(() => {
          this.setState({
            successful: true,
          }); 

          if (this.state.successful) {
            // alert("Signup sucessful!");
            this.handleShow();
            
          }
        })
        .catch((e) => {
          console.log(e);
          this.setState({
            successful: false,
          });
        });
    }


  }

  render() {
    const { message } = this.props;

    return (
      <>



        <Card className={"col-md-12"}>
          <Card.Header>
            <h1>Welcome to Starsrus!</h1>
          </Card.Header>


          <Form onSubmit={this.handleRegister} id="customerFormId" >

            <Card.Body>

              <Form.Row>
                <Form.Group as={Col} controlId="formGridFullname">
                  <Form.Label>Username*</Form.Label>
                  <Form.Control
                    type="text"
                    name="username"
                    value={this.state.username}
                    onChange={this.handleChange}
                    className={"mb3"}
                    placeholder="Maximum 30 Characters"
                    minLength="3"
                    maxLength="30"
                  />
                  <Form.Label className="formlabel-color-red">{this.state.usernameError}</Form.Label>
                  

                </Form.Group>




              </Form.Row>
              <Form.Row>
                <Form.Group as={Col} controlId="formGridUsername">
                  <Form.Label>Password*</Form.Label>
                  <Form.Control
                    type="text"
                    name="password"
                    value={this.state.password}
                    onChange={this.handleChange}
                    className={"mb3"}
                    placeholder="Maximum 30 Characters"
                    minLength="6"
                    maxLength="30"
                  />
                  <Form.Label className="formlabel-color-red">{this.state.passwordError}  {<div>{this.state.repeatpasswordError}</div>}</Form.Label>
                  
                </Form.Group>

                <Form.Group as={Col} controlId="formGridUsername">
                  <Form.Label>Repeat Password*</Form.Label>
                  <Form.Control
                    type="text"
                    name="repeatpassword"
                    value={this.state.repeatpassword}
                    onChange={this.handleChange}
                    className={"mb3"}
                    placeholder="Maximum 30 Characters"
                    minLength="6"
                    maxLength="30"
                  />
                </Form.Group>
              
                {/* <Form.Label className="formlabel-color-red"></Form.Label> */}
                
              </Form.Row>

              <Form.Row>
                <Form.Group as={Col} controlId="formGridUsername">
                  <Form.Label>First Name*</Form.Label>
                  <Form.Control
                    type="text"
                    name="firstname"
                    value={this.state.firstname}
                    onChange={this.handleChange}
                    className={"mb3"}
                    placeholder="Maximum 30 Characters"
                    maxLength="30"
                  />
                  
                  <Form.Label className="formlabel-color-red">{this.state.nameError}</Form.Label>

                </Form.Group>

                <Form.Group as={Col} controlId="formGridUsername">
                  <Form.Label>Last Name*</Form.Label>
                  <Form.Control
                    type="text"
                    name="lastname"
                    value={this.state.lastname}
                    onChange={this.handleChange}
                    className={"mb3"}
                    placeholder="Maximum 30 Characters"
                    maxLength="30"
                  />
                  
                </Form.Group>
              </Form.Row>

              <Form.Row>
                <Form.Group as={Col} controlId="email">
                  <Form.Label>Email*</Form.Label>
                  <Form.Control
                    type="email"
                    name="email"
                    value={this.state.email}
                    onChange={this.handleChange}
                    className={"mb3"}
                    placeholder="email@email.com"
                    isInvalid={message}
                  />
                  <Form.Label className="formlabel-color-red">{this.state.emailError}</Form.Label>
                </Form.Group>

                <Form.Group as={Col} controlId="dob">
                  <Form.Label>Date of Birth*</Form.Label>
                  <Form.Control
                    type="date"
                    name="dob"
                    value={this.state.dob}
                    onChange={this.handleChange}
                    className={"mb3"}
                    placeholder="Date of Birth"
                  />
                  
                  <Form.Label className="formlabel-color-red">{this.state.dobError}</Form.Label>
                </Form.Group>
              </Form.Row>

              <Form.Row>
                <Form.Group as={Col} controlId="address1" xs lg="5">
                  <Form.Label>Address Line 1*</Form.Label>
                  <Form.Control
                    type="text"
                    name="address1"
                    value={this.state.address1}
                    onChange={this.handleChange}
                    className={"mb3"}
                    placeholder="1235 Main St, City"
                  />

                </Form.Group>
                <Form.Group as={Col} controlId="address2" xs lg="5">
                  <Form.Label>Address Line 2</Form.Label>
                  <Form.Control
                    type="text"
                    name="address2"
                    value={this.state.address2}
                    onChange={this.handleChange}
                    className={"mb3"}
                    placeholder="Apartment #123"
                  />
                </Form.Group>
                <Form.Group as={Col} controlId="formGridState">
                  <Form.Label>State*</Form.Label>
                  <Form.Control
                    as="select"
                    custom
                    name="state"
                    // value={this.state.state}
                    onChange={this.handleChange}>
                    <option value="">Choose State</option>
                    <option value="AK">Alaska</option>
                    <option value="AL">Alabama</option>
                    <option value="AR">Arkansas</option>
                    <option value="AZ">Arizona</option>
                    <option value="CA">California</option>
                    <option value="CO">Colorado</option>
                    <option value="CT">Connecticut</option>
                    <option value="DC">District of Columbia</option>
                    <option value="DE">Delaware</option>
                    <option value="FL">Florida</option>
                    <option value="GA">Georgia</option>
                    <option value="HI">Hawaii</option>
                    <option value="IA">Iowa</option>
                    <option value="ID">Idaho</option>
                    <option value="IL">Illinois</option>
                    <option value="IN">Indiana</option>
                    <option value="KS">Kansas</option>
                    <option value="KY">Kentucky</option>
                    <option value="LA">Louisiana</option>
                    <option value="MA">Massachusetts</option>
                    <option value="MD">Maryland</option>
                    <option value="ME">Maine</option>
                    <option value="MI">Michigan</option>
                    <option value="MN">Minnesota</option>
                    <option value="MO">Missouri</option>
                    <option value="MS">Mississippi</option>
                    <option value="MT">Montana</option>
                    <option value="NC">North Carolina</option>
                    <option value="ND">North Dakota</option>
                    <option value="NE">Nebraska</option>
                    <option value="NH">New Hampshire</option>
                    <option value="NJ">New Jersey</option>
                    <option value="NM">New Mexico</option>
                    <option value="NV">Nevada</option>
                    <option value="NY">New York</option>
                    <option value="OH">Ohio</option>
                    <option value="OK">Oklahoma</option>
                    <option value="OR">Oregon</option>
                    <option value="PA">Pennsylvania</option>
                    <option value="PR">Puerto Rico</option>
                    <option value="RI">Rhode Island</option>
                    <option value="SC">South Carolina</option>
                    <option value="SD">South Dakota</option>
                    <option value="TN">Tennessee</option>
                    <option value="TX">Texas</option>
                    <option value="UT">Utah</option>
                    <option value="VA">Virginia</option>
                    <option value="VT">Vermont</option>
                    <option value="WA">Washington</option>
                    <option value="WI">Wisconsin</option>
                    <option value="WV">West Virginia</option>
                    <option value="WY">Wyoming</option>
                  </Form.Control>
                  
                  <Form.Label className="formlabel-color-red">{this.state.stateError}</Form.Label>
                </Form.Group>

              </Form.Row>

              <Form.Row>
                <Form.Group as={Col} controlId="formGridPhone">
                  <Form.Label >Phone Number*</Form.Label>
                  <Form.Control
                    type="number"
                    name="phone"
                    value={this.state.phone}
                    onChange={this.handleChange}
                    className={"mb3"}
                    placeholder="Enter phone number"
                    max="999999999"
                  />
                  <Form.Control.Feedback type="invalid">{this.state.phoneError}</Form.Control.Feedback>
                  <Form.Label className="formlabel-color-red">{this.state.passwordError}</Form.Label>
                </Form.Group>


                <Form.Group as={Col} controlId="formGridPhone">
                  <Form.Label >SSN</Form.Label>
                  <Form.Control
                    type="number"
                    name="ssn"
                    value={this.state.ssn}
                    onChange={this.handleChange}
                    className={"mb3"}
                    placeholder="Enter phone number"
                    max="999999999"
                  />

                </Form.Group>
              </Form.Row>
              <Form.Row>
                <Form.Group>
                  <Form.Check
                    required
                    name="terms"
                    label="Agree to terms and conditions"
                    onChange={this.handleChange}
                    // isInvalid={!!errors.terms}
                    // feedback={errors.terms}
                    id="validationFormik0"
                  />
                </Form.Group>
              </Form.Row>
              <Form.Row>
                <Form.Label>* required</Form.Label>
              </Form.Row>

            </Card.Body>

            <Card.Footer className="text-center">

              <Button type="summit" variant="rounded-corner" onClick={this.handleRegister} >
                Sign up
                    </Button>

              

            </Card.Footer>
          </Form>
          <Button variant="rounded-corner" onClick={this.handleShow} >
                 up
                    </Button>


        </Card>
        <Modal show={this.state.modalshow} onHide={this.handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Info</Modal.Title>
        </Modal.Header>
        <Modal.Body>Sign up successful!</Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={this.handleClose}>
            OK
          </Button>
        </Modal.Footer>
      </Modal>

      </>
    );
  }
}

function mapStateToProps(state) {
  const { message } = state.message;
  return {
    message,
  };
}

export default connect(mapStateToProps)(Register);