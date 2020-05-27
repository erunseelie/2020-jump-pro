import React, { useEffect } from "react";
import { Image } from "react-native";
import {
  Container,
  Card,
  Content,
  CardItem,
  Left,
  Body,
  Text,
  Thumbnail,
} from "native-base";
// Styles
import "./Rooms.less";
import { useOvermind } from "../../overmind/config";

export default function Rooms() {
  const { state, actions } = useOvermind();

  // a Hook to replace `componentDidMount()`.
  // TODO add caching so a refresh doesn't necessarily need to occur.
  useEffect(() => {
    actions.refreshRooms();
  }, []);
  // ? the empty array here ensures the component
  // ? doesn't continually re-render.
  // TODO add a refresh button?

  return (
    <Container>
      {/* <Header /> */}
      <Content>
        {state.rooms.map((room, i) => {
          return (
            <Card key={i}>
              <CardItem>
                <Left>
                  <Thumbnail source="https://i.imgur.com/PYVEDqI.jpg" />
                  <Body>
                    <Text>{room.name}</Text>
                    <Text note>Location:</Text>
                  </Body>
                </Left>
              </CardItem>
              <CardItem cardBody>
                <Image
                  source="https://i.imgur.com/PYVEDqI.jpg"
                  style={{ height: 200, width: null, flex: 1 }}
                />
              </CardItem>
            </Card>
          );
        })}
      </Content>
    </Container>
  );
}
