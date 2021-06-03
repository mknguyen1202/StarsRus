import logo from './logo.svg';
import './App.css';

import {BrowserRouter as Router, Switch, Route} from "react-router-dom";

import Customer from './components/Customer';
import CustomerList from './components/CustomerList';
import NavigationBar from "./components/NavigationBar";
import Home from "./components/Home";
import { Container } from 'react-bootstrap';
import Admin from './components/Admin';
import AdminList from './components/AdminList';

function App() {
  return (
    
    <Router>
      <NavigationBar /> 
        <Container>
        <Switch>
            <Route path="/" exact component={Home} />
            <Route path="/customer" exact component={CustomerList} />
            <Route path="/add_customer" exact component={Customer} />
            <Route path="/edit/:username" exact component={Customer} />
            <Route path="/admin" exact component={AdminList} />
            <Route path="/add_admin" exact component={Admin} />
        </Switch>
        </Container>
      </Router>
  );
}

export default App;
