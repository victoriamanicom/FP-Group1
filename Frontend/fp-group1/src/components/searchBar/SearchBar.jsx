import Col from 'react-bootstrap/Col';

const SearchBar = ({handleSearch, handleReset}) => {

    return (
        <>
            <form id="searchBarForm" onSubmit={handleSearch}>
                <Col md>
                    <FloatingLabel controlId="floatingForenames" label="Forenames">
                        <Form.Control type="text" name="searchForenames"/>
                    </FloatingLabel>
                </Col>
                <Col md>
                    <FloatingLabel controlId="floatingSurname" label="Surname">
                        <Form.Control type="text" name="searchSurname"/>
                    </FloatingLabel>
                </Col>
                <Col md>
                    <FloatingLabel controlId="floatingGender" label="Gender">
                        <Form.Select>
                            <option value="Female"></option>
                            <option value="Male"></option>
                            <option value="Unknown"></option>
                        </Form.Select>
                    </FloatingLabel>
                </Col>
                            <label>Surname</label>
                            <label class="container">Female
                                <input type="checkbox"/>
                                <span class="checkmark"></span>
                            </label>
                            <button type="submit">Search</button>
                        
                        <div class="col">
                            <input type="text" name="searchForenames"/>
                            <input type="text" name="searchSurname"/>
                            <label class="container">Male
                                <input type="checkbox"/>
                                <span class="checkmark"></span>
                            </label>
                            <button onClick={handleReset}>Reset</button>
                        </div>
                    </div>
                
            </form>
        </>
    )

}

export default SearchBar;