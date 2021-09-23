import './SearchBar.css';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import FloatingLabel from 'react-bootstrap/FloatingLabel';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

const SearchBar = ({
    handleSearch, handleReset, suspectForenames, setSuspectForenames,
    suspectSurname, setSuspectSurname, suspectGender, setSuspectGender
    }) => {

    return (
        <>
            <Form id="searchBarForm" onSubmit={(e) => handleSearch(e)}>
                <Row>
                    <Col >
                        <FloatingLabel controlId="floatingForenames" label="Forenames">
                            <Form.Control type="text" name="searchForenames" placeholder="Forenames"
                            value={suspectForenames} onChange={e => setSuspectForenames(e.target.value)}/>
                        </FloatingLabel>
                    </Col>
                    <Col >
                        <FloatingLabel controlId="floatingSurname" label="Surname">
                            <Form.Control type="text" name="searchSurname" placeholder="Surname"
                            value={suspectSurname} onChange={e => setSuspectSurname(e.target.value)}/>
                        </FloatingLabel>
                    </Col>
                    <Col>
                        <FloatingLabel controlId="floatingGender" label="Gender">
                            <Form.Select  name="searchGender" value={suspectGender}
                            onChange={e => setSuspectGender(e.target.value)}>
                                <option value=""></option>
                                <option value="Female">Female</option>
                                <option value="Male">Male</option>
                            </Form.Select>
                        </FloatingLabel>
                    </Col>
                    <Col xs={2} id="buttonColumn">
                        <Button id="searchButton" type="submit" >Search</Button>
                        <br />
                        <Button id="resetButton" onClick={(e) => handleReset(e)}>Reset</Button>
                    </Col>
                    
                </Row>
                
            </Form>
        </>
    )

}

export default SearchBar;