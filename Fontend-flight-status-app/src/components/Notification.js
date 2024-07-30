import React, { useState, useEffect } from 'react';

const Notification = () => {
  const [notifications, setNotifications] = useState([]);

  useEffect(() => {
    fetch('/mock-data/notifications.json')
      .then(response => response.json())
      .then(data => setNotifications(data))
      .catch(error => console.error('Error fetching notification data:', error));
  }, []);

  return (
    <div>
      <h2>Notifications</h2>
      <ul>
        {notifications.map(notification => (
          <li key={notification.notification_id}>
            {notification.message} (Sent via {notification.method} to {notification.recipient})
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Notification;
