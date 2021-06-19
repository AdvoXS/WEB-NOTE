import React, {Component} from 'react';
import {Navbar, NavbarBrand} from 'reactstrap';
import {Link} from 'react-router-dom';
import './App.css';
export default class AppNavbar extends Component {
    constructor(props) {
        super(props);
        this.state = {isOpen: false};
        this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    render() {
        return <Navbar color="dark" dark expand="md">
            <NavbarBrand tag={Link} to="/">Домашняя страница</NavbarBrand>
            <NavbarBrand tag={Link} to="/">Задачи</NavbarBrand>
            <NavbarBrand tag={Link} to="/reference">Сссылки</NavbarBrand>
            <NavbarBrand tag={Link} to="/">Записи</NavbarBrand>
        </Navbar>;
    }
}