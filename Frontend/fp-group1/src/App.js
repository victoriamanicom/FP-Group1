import "./App.css";
import Navbar from "react-bootstrap/NavBar";
import "material-icons/iconfont/material-icons.css";
import SearchBar from "./components/searchBar/SearchBar";
import { useState } from 'react';
import axios from 'axios';

function App() {

  const [suspectForenames, setSuspectForenames] = useState("");
  const [suspectSurname, setSuspectSurname] = useState("");
  const [suspectGender, setSuspectGender] = useState("");
  const [citizens, setCitizens] = useState([]);

  const handleReset = e => {
    setSuspectForenames("");
    setSuspectSurname("");
    setSuspectGender("");

  }

  const handleSearch = e => {
    e.preventDefault();
    axios
    .get()
    .then((result) => {
      setCitizens(result.data);
    })
    .catch(err => console.log(err));
  }

  return (
    <div className="App">
      <Navbar className="navbarHeader" fixed="sticky" variant="dark">
        <Navbar.Brand href="">
          <span className="material-icons">privacy_tip</span>
          National Investigation Unit
        </Navbar.Brand>
      </Navbar>
      <SearchBar handleReset={handleReset} handleSearch={handleSearch}
      suspectForenames={suspectForenames} setSuspectForenames={setSuspectForenames}
      suspectSurname={suspectSurname} setSuspectSurname={setSuspectSurname}
      suspectGender={suspectGender} setSuspectGender={setSuspectGender}/>
    </div>
  );
}

export default App;
