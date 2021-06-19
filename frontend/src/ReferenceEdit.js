import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavBar';
import './App.css';
class ReferenceEdit extends Component{
    emptyItem = {
        head: '',
        reference: '',
        description: '',
        group_id : ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const ref = await (await fetch(`/reference/${this.props.match.params.id}`)).json();
            this.setState({item: ref});
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;

        await fetch('/reference' + (item.id ? '/' + item.id : ''), {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/reference');
    }

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Редактирование ссылки' : 'Добавление ссылки'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="head">Заголовок</Label>
                        <Input type="text" name="head" id="head" value={item.head || ''}
                               onChange={this.handleChange} autoComplete="head"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="reference">Ссылка</Label>
                        <Input type="text" name="reference" id="reference" value={item.reference || ''}
                               onChange={this.handleChange} autoComplete="reference"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="description">Описание</Label>
                        <Input type="text" name="description" id="description" value={item.description || ''}
                               onChange={this.handleChange} autoComplete="description"/>
                    </FormGroup>
                    <FormGroup>
                        <label>
                            Группа:
                            <select name="group_id" id="group_id"
                                    value={item.group_id || ''} onChange={this.handleChange}
                                    autoComplete="group_id">
                                <option value="1">Test</option>
                            </select>
                        </label>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Сохранить</Button>{' '}
                        <Button color="secondary" tag={Link} to="/reference">Отмена</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}
export default withRouter(ReferenceEdit);