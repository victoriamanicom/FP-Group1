import "./App.css";
import Navbar from "react-bootstrap/NavBar";
import Button from "react-bootstrap/Button";
import "material-icons/iconfont/material-icons.css";
import SearchBar from "./components/searchBar/SearchBar";
import CitizenReturn from "./components/CitizenReturn/CitizenReturn";
import CitizenAbout from "./components/CitizenAbout/CitizenAbout";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

function App() {
  return (
    <Router className="App">
      <Navbar className="navbarHeader" sticky="top">
        <Navbar.Brand className="navbarTitle" href="">
          <span class="material-icons">privacy_tip</span>
          National Investigation Unit
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          {/* <SearchBar /> */}
        </Navbar.Collapse>
      </Navbar>
      <SearchBar />

      <Switch>
        <Route exact path="/">
          <CitizenReturn />
        </Route>
        <Route path="/about/:lastName">
          <CitizenAbout />
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
